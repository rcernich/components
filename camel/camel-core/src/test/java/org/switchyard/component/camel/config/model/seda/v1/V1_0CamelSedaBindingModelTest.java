/*
 * Copyright 2013 Red Hat Inc. and/or its affiliates and other contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.switchyard.component.camel.config.model.seda.v1;

import org.switchyard.component.camel.core.model.Constants;
import org.switchyard.component.camel.core.model.v1.V1CamelBindingModel;

/**
 * Test for {@link V1CamelBindingModel}.
 */
public class V1_0CamelSedaBindingModelTest extends V1CamelSedaBindingModelTest {

    private static final String CAMEL_XML = "switchyard-seda-binding-beans-1.0.xml";

    private static final String CAMEL_URI = "seda://fooSedaName?size=55" +
        "&waitForTaskToComplete=Always&concurrentConsumers=3" +
        "&timeout=1000&multipleConsumers=true&limitConcurrentConsumers=false";

    public V1_0CamelSedaBindingModelTest() {
        super(CAMEL_XML, Constants.CORE_NAMESPACE_V1_0);
    }

    @Override
    protected String createEndpointUri() {
        return CAMEL_URI;
    }

}