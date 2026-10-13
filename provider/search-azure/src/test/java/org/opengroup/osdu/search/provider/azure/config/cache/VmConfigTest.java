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

package org.opengroup.osdu.search.provider.azure.config.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.opengroup.osdu.core.common.cache.VmCache;
import org.opengroup.osdu.core.common.model.entitlements.Groups;
import org.opengroup.osdu.core.common.model.search.CursorSettings;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class VmConfigTest {

    private static final Integer expiration=900;
    private static final Integer maxSize=900;

    @InjectMocks
    public VmConfig sut;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(VmConfigTest.this);
    }

    @Test
    public void groupCache_shouldCreateNonNullObjectOfTypeVmCache() {
        VmCache<String, Groups> vmCache = sut.groupCache(expiration, maxSize);
        assertNotNull(vmCache);
    }

    @Test
    public void cursorCache_shouldCreateNonNullObjectOfTypeVmCache() {
        VmCache<String, CursorSettings> vmCache = sut.cursorCache(expiration, maxSize);
        assertNotNull(vmCache);
    }
}
