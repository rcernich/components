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
package org.switchyard.component.camel.quartz.model.v1;

import java.util.Map;

import org.switchyard.component.camel.common.model.AdditionalUriParametersModel;
import org.switchyard.component.camel.quartz.Constants;

/**
 * Test for {@link V1CamelQuartzBindingModel}.
 */
public class V1_0CamelQuartzBindingModelTest extends V1CamelQuartzBindingModelTest {

    private static final String CAMEL_XML = "/v1/switchyard-quartz-binding-beans-1.0.xml";

    private static final String CAMEL_URI = "quartz://MyJob?cron=0 0 12 * * ?&stateful=true" +
        "&trigger.startTime=2011-01-01T12:00:00&trigger.endTime=2011-01-01T12:00:00";

    public V1_0CamelQuartzBindingModelTest() {
        super(CAMEL_XML, Constants.QUARTZ_NAMESPACE_V1_0);
    }

    @Override
    protected String createEndpointUri() {
        return CAMEL_URI;
    }

    @Override
    protected AdditionalUriParametersModel createAdditionalUriParametersModel(String namespace,
            Map<String, String> parameters) {
        return null;
    }
    
    @Override
    protected String getTimeZone() {
        return null;
    }
}
