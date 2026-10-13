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
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class AADConfigurationTest {

    private static final String authority = "authority";
    private static final String clientId = "clientId";
    private static final String secretKey = "secretKey";
    private static final String oboApiField = "oboApi";
    private static final String oboApi = "OboApi";

    @InjectMocks
    AADConfiguration sut;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(AADConfigurationTest.this);
        ReflectionTestUtils.setField(sut, authority, authority);
        ReflectionTestUtils.setField(sut, clientId, clientId);
        ReflectionTestUtils.setField(sut, secretKey, secretKey);
        ReflectionTestUtils.setField(sut, oboApiField, oboApi);
    }

    @Test
    void should_return_setValue_when_getAuthority_isCalled() {
        assertEquals(authority + "/", sut.getAuthority());
    }

    @Test
    void should_return_setValue_when_getAuthority_withoutSlashSuffix_isCalled() {
        ReflectionTestUtils.setField(sut, authority, authority + "/");
        assertEquals(authority + "/", sut.getAuthority());
    }

    @Test
    void should_return_setValue_when_getClientId_isCalled() {
        assertEquals(clientId, sut.getClientId());
    }

    @Test
    void should_return_setValue_when_getSecretKey_isCalled() {
        assertEquals(secretKey, sut.getSecretKey());
    }

    @Test
    void should_return_setValue_when_getOboApi_isCalled() {
        assertEquals(oboApi, sut.getOboApi());
    }
}
