//  Copyright © Microsoft Corporation
//
//  Licensed under the Apache License, Version 2.0 (the "License");
//  you may not use this file except in compliance with the License.
//  You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//  Unless required by applicable law or agreed to in writing, software
//  distributed under the License is distributed on an "AS IS" BASIS,
//  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//  See the License for the specific language governing permissions and
//  limitations under the License.

package org.opengroup.osdu.search.provider.azure.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.opengroup.osdu.core.common.entitlements.IEntitlementsFactory;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class AzureBootstrapConfigTest {

    private static final String keyVaultURLField = "keyVaultURL";
    private static final String keyVaultURL = "keyVaultURL.com";
    private static final String elasticCacheExpirationField = "elasticCacheExpiration";
    private static final Integer elasticCacheExpiration = 900;
    private static final String elasticCacheMaxSizeField = "elasticCacheMaxSize";
    private static final Integer elasticCacheMaxSize = 900;
    private static final String entitlementsAPIKey = "entitlementsAPIKey";
    private static final String entitlementsAPIEndpointField = "entitlementsAPIEndpoint";
    private static final String entitlementsAPIEndpoint = "entitlementsAPIEndpoint.com";

    @InjectMocks
    public AzureBootstrapConfig sut;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(AzureBootstrapConfigTest.this);
        ReflectionTestUtils.setField(sut, keyVaultURLField, keyVaultURL);
        ReflectionTestUtils.setField(sut, elasticCacheExpirationField, elasticCacheExpiration);
        ReflectionTestUtils.setField(sut, elasticCacheMaxSizeField, elasticCacheMaxSize);
        ReflectionTestUtils.setField(sut, entitlementsAPIKey, entitlementsAPIKey);
        ReflectionTestUtils.setField(sut, entitlementsAPIEndpointField, entitlementsAPIEndpoint);
    }

    @Test
    public void should_return_setValue_when_getKeyVaultURL_isCalled() {
        assertEquals(sut.getKeyVaultURL(), keyVaultURL);
    }

    @Test
    public void should_return_setValue_when_getElasticCacheExpiration_isCalled() {
        assertEquals(sut.getElasticCacheExpiration(), elasticCacheExpiration);
    }

    @Test
    public void should_return_setValue_when_getElasticCacheMaxSize_isCalled() {
        assertEquals(sut.getElasticCacheMaxSize(),elasticCacheMaxSize);
    }

    @Test
    public void should_return_nonEmptyEntitlementsFactory() {
        IEntitlementsFactory iEntitlementsFactory = sut.entitlementsFactory();
        assertNotNull(iEntitlementsFactory);
    }
}
