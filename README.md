# OSDU Search Service for Azure

[![Release](https://img.shields.io/github/v/release/Azure/osdu-spi-search)](https://github.com/Azure/osdu-spi-search/releases)
[![Validate](https://github.com/Azure/osdu-spi-search/actions/workflows/validate.yml/badge.svg?branch=main)](https://github.com/Azure/osdu-spi-search/actions/workflows/validate.yml)
[![License: Apache 2.0](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](LICENSE)

> [!NOTE]
> Shared service code comes from the [OSDU community upstream](https://community.opengroup.org/osdu/platform/system/search-service); the [OSDU documentation](https://osdu.pages.opengroup.org/platform/system/search-service/) covers the API.

Search answers queries over the records indexed in a data partition, filtering by kind, text, attribute, and location, and pages through large result sets with a cursor.

## At a glance

| | |
|---|---|
| API base path | `/api/search/v2/` |
| Swagger UI | `/api/search/v2/swagger` |
| Health | `:8081/actuator/health` |
| Depends on | Partition, Entitlements; Indexer fills the indexes it reads |
| Azure resources | Key Vault (Elasticsearch and Redis connection secrets); Elasticsearch and Redis themselves run inside the cluster |
| Deployed by | [OSDU SPI Stack](https://github.com/Azure/osdu-spi-stack) (`software/stacks/osdu/services/search.yaml`) |

## Repository layout

[CONTRIBUTING.md](CONTRIBUTING.md) explains where each kind of change belongs.

| Path | Owner | Contents |
|---|---|---|
| `search-core/` | OSDU upstream | Shared service code |
| `provider/search-azure/` | This repository | Azure provider |
| `search-acceptance-test/` | OSDU upstream | End-to-end suite run against a deployed environment |
| `testing/search-test-core/` | OSDU upstream | Shared steps for the integration tests |
| `testing/search-test-azure/` | This repository | Legacy Azure integration tests |
| `.spi/service.yaml` | This repository | How CI deploys and tests the service on SPI Stack |

## Build

Requires Java 25 and Maven 3.6.3+. OSDU dependencies resolve from the public community registry through the settings file in `.mvn`:

```bash
mvn --settings .mvn/community-maven.settings.xml -P core,azure clean install
```

The runnable jar lands at `provider/search-azure/target/search-azure-*-spring-boot.jar`.

## Configuration

SPI Stack sets the service's environment from two places: the shared `osdu-config` ConfigMap and the service's own entry in [`services/search.yaml`](https://github.com/Azure/osdu-spi-stack/blob/main/software/stacks/osdu/services/search.yaml). Those files are the contract; the tables below list what Search actually reads from them.

**Shared, from `osdu-config`:**

| Variable | Purpose |
|---|---|
| `AAD_CLIENT_ID` | Application ID that caller tokens are issued for |
| `KEYVAULT_URI` | Central Key Vault |
| `SERVER_PORT` | HTTP port (`8080`); `application.properties` gives `server.port` no default |
| `REDIS_PORT` | Redis port (`6379`), which takes precedence over the `6380` default in `application.properties` |

**Specific to Search**, from `services/search.yaml`:

| Variable and value on SPI Stack | Purpose |
|---|---|
| `SERVER_SERVLET_CONTEXTPATH`<br>`/api/search/v2/` | API base path |
| `AZURE_ISTIOAUTH_ENABLED`<br>`true` | Trust the mesh's token validation |
| `AZURE_PAAS_WORKLOADIDENTITY_ISENABLED`<br>`true` | Authenticate to Azure with workload identity |
| `PARTITION_SERVICE_ENDPOINT`<br>`http://partition/api/partition/v1` | Per-partition resource lookup |
| `ENTITLEMENTS_SERVICE_ENDPOINT`<br>`http://entitlements/api/entitlements/v2` | Caller authorization |
| `ENTITLEMENTS_SERVICE_API_KEY`<br>`OBSOLETE` | Legacy key passed to the Entitlements client; the property has no default, so the placeholder must stay set |
| `COSMOSDB_DATABASE`<br>`osdu-db` | Database inside each partition's Cosmos DB account |
| `REDIS_DATABASE`<br>`5` | Redis database index for Search's caches |
| `ELASTIC_CACHE_EXPIRATION`<br>`1` | Minutes Elasticsearch credentials stay cached |
| `MAX_CACHE_VALUE_SIZE`<br>`60` | Entries each in-memory cache holds |
| `POLICY_SERVICE_ENABLED`<br>`false` | Policy checks are off; SPI Stack deploys no Policy service |
| `POLICY_SERVICE_ENDPOINT`<br>`http://policy/api/policy/v1` | Policy service, unused while policy checks are off |

The service authenticates to Azure with workload identity, which injects `AZURE_CLIENT_ID` and a federated token; there are no client secrets. Per-partition resources are resolved at request time through the Partition service.

## Test

| Suite | Where | Runs in CI | Run it yourself |
|---|---|---|---|
| Unit | `search-core`, `provider/search-azure` | Pull requests (Java Build) | `mvn ... install` from [Build](#build) |
| Acceptance | [`search-acceptance-test`](search-acceptance-test/docs/README.md) | Pull requests, against SPI Stack (Deploy and Test) | `spi test search` |
| Integration | `testing/search-test-core`, `testing/search-test-azure` | No | See below |

CI runs these on pull requests from this repository that change code. Documentation-only changes skip the build, and pull requests from forks build without deploying.

**Acceptance** proves a change on real infrastructure before it merges. It calls the deployed service through the gateway as a privileged test identity, and the bindings in `.spi/service.yaml` supply its inputs. Against an environment you are connected to:

```bash
spi test search                   # the image and suite the environment is running
spi test search --source .        # this checkout's suite and descriptor
```

**Integration** is the older suite carried from upstream. It sits outside the root Maven build and CI does not run it. It signs in as a service principal with a client secret (`INTEGRATION_TESTER`, `AZURE_TESTER_SERVICEPRINCIPAL_SECRET`) and takes no bearer token, so it cannot run against SPI Stack, which issues no client secrets. Acceptance covers the same API surface.

To call the API by hand, `spi token` mints a bearer token:

```bash
curl -H "Authorization: Bearer $(spi token)" -H "data-partition-id: <partition>" \
  -H "Content-Type: application/json" -d '{"kind": "*:*:*:*", "limit": 10}' \
  https://<gateway>/api/search/v2/query
```

## Deploy

For a pull request from this repository that changes code, CI publishes the service image and its test suite image, `osdu-spi-search-acceptance`, to GHCR, and the Deploy and Test lane borrows an SPI Stack environment, runs the new image there, proves it with the acceptance suite, and restores the environment's own image. When that lane runs and passes, the change is proven on real infrastructure before it merges; the Validation Summary on the pull request shows whether it ran. This repository does not own infrastructure; SPI Stack does.

To try a build by hand on an environment you are connected to, pin it by digest and release the pin when done:

```bash
spi service pin search --image ghcr.io/azure/osdu-spi-search@sha256:<digest>
spi service reset search
```

## Service notes

**Elasticsearch and Redis connections.** Neither comes from an environment variable. Each partition's record in the Partition service names the Key Vault secrets that hold its Elasticsearch endpoint, user name, password, and TLS setting, so Search queries whichever cluster that partition points at. Redis is shared across partitions; its host name and password come from the Key Vault secrets `redis-hostname` and `redis-password`. Both connections use TLS, and on SPI Stack the deployment imports the in-cluster Elasticsearch and Redis CA certificates into the service's Java truststore.

## License

Copyright © Microsoft Corporation

Licensed under the [Apache License 2.0](LICENSE).
