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

package org.opengroup.osdu.search.provider.azure.cache.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedConstruction;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.opengroup.osdu.core.common.cache.VmCache;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.spy;

@ExtendWith(MockitoExtension.class)
public class FieldTypeMappingCacheImplTest {

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(FieldTypeMappingCacheImplTest.this);
    }

    @Test
    public void when_FieldTypeMappingCache_isCreated_then_VMCacheConstructorIsCalled_and_objectReturnedIsNotNull() {
        FieldTypeMappingCacheImpl spyCache = spy(new FieldTypeMappingCacheImpl());
        Field field = ReflectionUtils.findField(VmCache.class, "cache");
        assertNotNull(field);

        ReflectionUtils.makeAccessible(field);
        Object cacheValue = ReflectionUtils.getField(field, spyCache);

        assertNotNull(cacheValue);
    }
}
