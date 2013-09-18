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
package org.switchyard.component.camel.ftp.model.v1;

import org.switchyard.component.camel.ftp.Constants;

/**
 * Test for {@link V1CamelFtpBindingModel}.
 */
public class V1_0CamelFtpBindingModelTest extends V1CamelFtpBindingModelTest {

    private static final String CAMEL_XML = "/v1/switchyard-ftp-binding-beans-1.0.xml";

    private static final String CAMEL_URI = "ftp://camel:secret@localhost:203/test?autoCreate=false&binary=true&" +
        "connectTimeout=10&disconnect=true&maximumReconnectAttempts=10&reconnectDelay=10&" +
        "separator=UNIX&stepwise=true&throwExceptionOnConnectFailed=true&passiveMode=true&" +
        "timeout=10&soTimeout=10&siteCommand=PWD&initialDelay=500";

    public V1_0CamelFtpBindingModelTest() {
        super(CAMEL_XML, Constants.FTP_NAMESPACE_V1_0);
    }

    @Override
    protected String createEndpointUri() {
        return CAMEL_URI;
    }

}
