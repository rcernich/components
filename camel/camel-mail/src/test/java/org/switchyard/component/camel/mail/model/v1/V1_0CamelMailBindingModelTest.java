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
package org.switchyard.component.camel.mail.model.v1;

import org.switchyard.component.camel.mail.model.Constants;

/**
 * Test for {@link V1CamelMailBindingModel}.
 */
public class V1_0CamelMailBindingModelTest extends V1CamelMailBindingModelTest {

    private static final String CAMEL_XML = "/v1/switchyard-mail-binding-beans-1.0.xml";
    private static final String CAMEL_URI = "imaps://localhost:233?connectionTimeout=300&"
        + "password=rider&username=camel";

    public V1_0CamelMailBindingModelTest() {
        super(CAMEL_XML, Constants.MAIL_NAMESPACE_V1_0);
    }

    @Override
    protected String createEndpointUri() {
        return CAMEL_URI;
    }

}
