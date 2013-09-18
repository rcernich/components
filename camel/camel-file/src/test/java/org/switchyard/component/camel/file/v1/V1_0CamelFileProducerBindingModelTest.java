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
package org.switchyard.component.camel.file.v1;

import org.switchyard.component.camel.file.model.Constants;

/**
 * Test for {@link V1CamelBindingModel}.
 * 
 * @author Mario Antollini
 */
public class V1_0CamelFileProducerBindingModelTest extends V1CamelFileProducerBindingModelTest {

    private static final String CAMEL_XML = "/v1/switchyard-file-binding-producer-beans-1.0.xml";

    private static final String CAMEL_URI = 
        "file:///input/directory?autoCreate=false&fileExist=Override" +
        "&tempPrefix=prefix_&keepLastModified=false" +
        "&eagerDeleteTargetFile=true&doneFileName=processed";

    public V1_0CamelFileProducerBindingModelTest() {
        super(CAMEL_XML, Constants.FILE_NAMESPACE_V1_0);
    }

    @Override
    protected String createEndpointUri() {
        return CAMEL_URI;
    }

}
