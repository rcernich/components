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
package org.switchyard.component.camel.netty.model.v1;

import org.switchyard.component.camel.netty.model.Constants;

/**
 * Test for {@link V1CamelNettyBindingModel} checking if it works with sslContextParametersRef.
 */
public class V1_0CamelNettyTcpBindingSslContextParameterRefModelTest extends CamelNettyTcpBindingSslContextParameterRefModelTest {

    private static final String CAMEL_XML = "/v1/switchyard-netty-tcp-binding-ssl-config-beans-1.0.xml";

    private static final String CAMEL_URI = "netty:tcp://google.com:10230?" +
        "ssl=true&sslContextParametersRef=#sslConfig";

    public V1_0CamelNettyTcpBindingSslContextParameterRefModelTest() {
        super(CAMEL_XML, Constants.NETTY_NAMESPACE_V1_0);
    }
    @Override
    protected String createEndpointUri() {
        return CAMEL_URI;
    }
}