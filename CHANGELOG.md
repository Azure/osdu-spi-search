# Changelog

## [1.4.0](https://github.com/Azure/osdu-spi-search/compare/v1.3.0...v1.4.0) (2026-10-14)


### ✨ Features

* **acceptance-test:** Support configurable OIDC scope and access_token ([8421549](https://github.com/Azure/osdu-spi-search/commit/842154963d434db529296baf1bb1154dcda15f48))
* **acceptance-test:** Support configurable OIDC scope and access_token ([5e82967](https://github.com/Azure/osdu-spi-search/commit/5e8296757f8357117d36624f791ea3accad8d56c))
* **azure:** Switch Redis authentication from password to MSI ([18620e6](https://github.com/Azure/osdu-spi-search/commit/18620e643cef26ea70495dea75bb6a1aef2f47c0))
* **azure:** Switch Redis authentication from password to MSI ([2add145](https://github.com/Azure/osdu-spi-search/commit/2add1454490cade9aee80bff5cf6ddcde46bca3c))
* Initial code ([289e6ea](https://github.com/Azure/osdu-spi-search/commit/289e6ea9c837c3bae4e096915cda629533abeb71))


### 🐛 Bug Fixes

* Align BOM + flatten testing/ layout to generate testing artifacts ([c436e50](https://github.com/Azure/osdu-spi-search/commit/c436e50ba994f60ed6a4fc65c1d8f0e29806f5fd))
* Align BOM + flatten testing/ layout to generate testing artifacts ([98cd82f](https://github.com/Azure/osdu-spi-search/commit/98cd82f5d6f967b4032c8a2c8604b55c3a6dbb89))
* Aws acceptance tests ([af8e248](https://github.com/Azure/osdu-spi-search/commit/af8e24874407f3d2a5409bff2988827452966271))
* Aws elastic client after connection closed fix ([647d840](https://github.com/Azure/osdu-spi-search/commit/647d8403f9f9310c4d81c48700cc56c08a09fdf8))
* Aws elastic client after connection closed fix ([b55a4cf](https://github.com/Azure/osdu-spi-search/commit/b55a4cfdad754a2b88b8c9338740f5d810de0d5c))
* **azure:** JaCoCo 0.8.14 for the Java 25 build ([e7b9c81](https://github.com/Azure/osdu-spi-search/commit/e7b9c8163020cd622b61e15cbcdd9fd72521ce09))
* **azure:** Netty-bom before core-lib-azure (lettuce 7.5.2 NoClassDefFoundError) ([7d55f84](https://github.com/Azure/osdu-spi-search/commit/7d55f843cad488c17b968b354fd3b6b08ee7e0e3))
* **azure:** Netty-bom before core-lib-azure (lettuce 7.5.2 NoClassDefFoundError) ([5fa2e9d](https://github.com/Azure/osdu-spi-search/commit/5fa2e9dcd2bf5b6691278fa2ee3e75639cef8cea))
* Build SearchAfterSettings via builder in cache test ([252b9d6](https://github.com/Azure/osdu-spi-search/commit/252b9d659e305d6c96a52779ffe1b6cb48b35b91))
* Build SearchAfterSettings via builder in cache test ([2c4e1f4](https://github.com/Azure/osdu-spi-search/commit/2c4e1f415558cfb3362d3e7d7c38870aaaa9b43b))
* Cve and spring-boot version bump ([c32cf5e](https://github.com/Azure/osdu-spi-search/commit/c32cf5eb0a1cf7727b0c53b89fdd8744e9e492f4))
* Cve and spring-boot version bump ([39fceff](https://github.com/Azure/osdu-spi-search/commit/39fceff633130e7749a733afe3cc77fdae6fe5eb))
* Cve update ([07d6b50](https://github.com/Azure/osdu-spi-search/commit/07d6b50c317b6bfe618115ba8f5ca3f0f1651c54))
* Cve update ([52e1dce](https://github.com/Azure/osdu-spi-search/commit/52e1dceb03e39b942552e91eed691f113e4f4dc2))
* **cve:** Pom cleanup + spring-boot 3.5.16 CVE remediation ([ac3b20c](https://github.com/Azure/osdu-spi-search/commit/ac3b20ce75a47859cc489f239ef64959efdd9091))
* **cve:** Pom cleanup + spring-boot 3.5.16 CVE remediation ([47357c7](https://github.com/Azure/osdu-spi-search/commit/47357c7c6fe9833211435d5072ca560a620bd7c9))
* Elasticsearch client cache poisoned by /info endpoint using request-scoped tenant context ([6652faf](https://github.com/Azure/osdu-spi-search/commit/6652faf7077280371229a68e89d6731b4bf14a37))
* Elasticsearch client cache poisoned by /info endpoint using request-scoped tenant context ([488d03a](https://github.com/Azure/osdu-spi-search/commit/488d03a713257cf11947bf599558a353b283aa15))
* Removing insertion of users groups into header which causes status 431 Request Header Fields Too Large error when user belongs to too many groups ([9b109bc](https://github.com/Azure/osdu-spi-search/commit/9b109bcc8a85b2561fac21915e891c24e88122ca))
* Removing insertion of users groups into header which causes status 431 Request Header Fields Too Large error when user belongs to too many groups ([85c9937](https://github.com/Azure/osdu-spi-search/commit/85c9937836a20e130b87b73e6f831ab6a4f9c548))
* Sonar Report not being updated ([d1409f2](https://github.com/Azure/osdu-spi-search/commit/d1409f27d524e3e230124190b78235f6155daaf0))
* Sonar source fix ([fc4b8b6](https://github.com/Azure/osdu-spi-search/commit/fc4b8b693096d31e0e7b168b2b54cc43c34ad6e6))
* Spring cves ([558ac47](https://github.com/Azure/osdu-spi-search/commit/558ac4741abad684d094439c06b1bbaf891baf30))
* Spring cves ([61b13ee](https://github.com/Azure/osdu-spi-search/commit/61b13ee597278d4856631e965344c9282902f9a6))
* Spring-core tomcat netty version bump ([e273758](https://github.com/Azure/osdu-spi-search/commit/e273758623b7ac4385eb0219b23105ff2bfb44d2))
* Spring-core tomcat netty version bump ([728f887](https://github.com/Azure/osdu-spi-search/commit/728f887df09e40e6f0f571d5cd2973134dd7ae0c))
* Tomcat-core security-crypto netty-common json-smart cve ([36734e6](https://github.com/Azure/osdu-spi-search/commit/36734e6510cb64e6d263ad295ea77bb90e0116c8))
* Tomcat-core security-crypto netty-common json-smart cve ([1b7ce0c](https://github.com/Azure/osdu-spi-search/commit/1b7ce0c5d248dd054e991eac7b08df0f9b7e5562))
* Updated junit dependencies ([41674bf](https://github.com/Azure/osdu-spi-search/commit/41674bff8949b660b6a0d56e87148c84d60c3bb7))
* Updated junit dependencies ([14ffef8](https://github.com/Azure/osdu-spi-search/commit/14ffef8ca05db7c7739fe654c3e0e4ce4b4b278c))


### 📚 Documentation

* Fill in root README for Search and drop provider README ([6313e63](https://github.com/Azure/osdu-spi-search/commit/6313e63605eda7a152f8745316e0b4c77f999b48))
* Root README in the standard SPI service format ([e466f4d](https://github.com/Azure/osdu-spi-search/commit/e466f4d5e26cb354fd37177dd386f80f26787ad5))


### 🔧 Miscellaneous

* **azure:** Add Apache 2.0 license headers to source files ([ac457b7](https://github.com/Azure/osdu-spi-search/commit/ac457b754f3589cf9939bc4332239def286b5cbd))
* **ci:** Remove IBM jobs from pipeline ([07b6769](https://github.com/Azure/osdu-spi-search/commit/07b67696c374800deac3632326ef718873c8c8ea))
* **ci:** Remove IBM jobs from pipeline ([0a4c083](https://github.com/Azure/osdu-spi-search/commit/0a4c0838e811b15309737f26271ce96d02f532a3))
* Complete repository initialization ([98b5a36](https://github.com/Azure/osdu-spi-search/commit/98b5a36fb9c605269184749f00e6b81bca6b94c2))
* Copy configuration and workflows from main branch ([51a72c2](https://github.com/Azure/osdu-spi-search/commit/51a72c2beeeee093d5f788623c43b4184a436bb6))
* Defaulting collaboration ff to true to avoid compatability issues after... ([67932b7](https://github.com/Azure/osdu-spi-search/commit/67932b76bb13294c07f6110e47aa39fe5f349908))
* Defaulting collaboration ff to true to avoid compatability issues after... ([5600e02](https://github.com/Azure/osdu-spi-search/commit/5600e02e5073f5b1ac7a7319d062822e9282b6fd))
* Deleting aws helm chart ([d5b320f](https://github.com/Azure/osdu-spi-search/commit/d5b320ff7e609bdd480c76d7bfc2c008932defd2))
* Deleting aws helm chart ([afbb885](https://github.com/Azure/osdu-spi-search/commit/afbb885f9ce3ab365a6a653f9dfe979dda2e12a1))
* Fixing sonar issues ([57679e0](https://github.com/Azure/osdu-spi-search/commit/57679e034b9a42735249abe4c223a6be85e5ddce))
* Fixing sonar issues ([f057466](https://github.com/Azure/osdu-spi-search/commit/f0574667ab6055ff417c7efc4f74d541696c2a23))
* Generate filtered upstream tree ([de5fc5c](https://github.com/Azure/osdu-spi-search/commit/de5fc5ca39ce5df1f313d731e178139162feb45b))
* License headers for the release review ([7664d37](https://github.com/Azure/osdu-spi-search/commit/7664d37e2356a09132c6ccd052a11b9976946bd2))
* Remove AWS provider and AWS CI/CD ([911d86f](https://github.com/Azure/osdu-spi-search/commit/911d86f044eb9ed8df72d848357f229edf53340e))
* Remove AWS provider and AWS CI/CD ([41a9f07](https://github.com/Azure/osdu-spi-search/commit/41a9f07eba944d3afea57cbd989f0f519f367787))
* Removing helm copy from aws buildspec ([86d3ab4](https://github.com/Azure/osdu-spi-search/commit/86d3ab4477fd4b61b3c9a6e599e0b287e4024c8c))
* Seed fork-owned azure trees ([fc67073](https://github.com/Azure/osdu-spi-search/commit/fc670732a7d0fe09d7bc829d02f1041a48926309))
* **spi:** Add service descriptor for search service ([93ae4ef](https://github.com/Azure/osdu-spi-search/commit/93ae4efdd17830096d701b252b36db03cc90ccd7))
* **spi:** Add service descriptor for search service ([876a0c2](https://github.com/Azure/osdu-spi-search/commit/876a0c25c4ea39c142ab50ee5af99a1833a84e3c))
* Sync template updates ([f14f2c4](https://github.com/Azure/osdu-spi-search/commit/f14f2c47aedfee067bfc9968c7204e335d4c58cd))
* Sync template updates ([e5908d4](https://github.com/Azure/osdu-spi-search/commit/e5908d4b28d8e8490f0be286cffa1a4b70d312c1))
* **template-sync:** Sync template updates 2026-10-13 ([1213d4a](https://github.com/Azure/osdu-spi-search/commit/1213d4ae6a675f62483eb3390653092f22d79f3c))
* **template-sync:** Sync template updates 2026-10-14 ([be6b533](https://github.com/Azure/osdu-spi-search/commit/be6b533ee972c03404ab9bba3a05668ee34c9c92))


### ♻️ Code Refactoring

* **audit:** Encapsulate audit roles and request context in logging layer ([eef9bdc](https://github.com/Azure/osdu-spi-search/commit/eef9bdc390474e8707b1623c14bd04159e966e6f))
* **audit:** Encapsulate audit roles and request context in logging layer ([648c3dc](https://github.com/Azure/osdu-spi-search/commit/648c3dcb9c393d9b585247f503dea89ff0f99264))


### 🔨 Build System

* **deps:** Bump okhttp, cucumber, logback, and netty ([9fa2cf6](https://github.com/Azure/osdu-spi-search/commit/9fa2cf693edf7f0df6a17815b5d7e76acc64da3d))
* **deps:** Bump okhttp, cucumber, logback, and netty ([80df46b](https://github.com/Azure/osdu-spi-search/commit/80df46ba5aba5d592dfa66c7eb99895d57a0e771))
* **search-azure:** Bump jacoco plugin to 0.8.14 ([4d22242](https://github.com/Azure/osdu-spi-search/commit/4d22242930e6712c65256ef5fabcc3a88fdce49e))


### ⚙️ Continuous Integration

* **fix:** Adding cimpl-prod-acceptance-test overrides ([6e5a5df](https://github.com/Azure/osdu-spi-search/commit/6e5a5dfc980134c50aed9978a43181777811f7a6))
