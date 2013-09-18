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
package org.switchyard.component.camel.amqp.model.v1;

import java.util.Map;

import org.switchyard.component.camel.amqp.model.Constants;
import org.switchyard.component.camel.common.model.AdditionalUriParametersModel;

/**
 * Test for amqp 1.0 binding model.
 */
public class V1_0CamelAmqpBindingModelTest extends V1CamelAmqpBindingModelTest {

    private static final String CAMEL_XML = "/v1/switchyard-amqp-binding-beans-1.0.xml";
    private static final String CAMEL_URI = "amqp:topic:esb_in_topic?connectionFactory=connFactory&" +
            "username=camel&password=isMyFriend&clientId=esb_in&durableSubscriptionName=esb_in_sub&" +
            "concurrentConsumers=5&maxConcurrentConsumers=15&disableReplyTo=true&preserveMessageQos=true&" +
            "deliveryPersistent=false&priority=9&explicitQosEnabled=true&replyTo=esb_out&replyToType=Shared&" +
            "requestTimeout=300&selector=DEST='ESB'&timeToLive=3600&transacted=true";

    public V1_0CamelAmqpBindingModelTest() {
        super(CAMEL_XML, Constants.AMQP_NAMESPACE_V1_0);
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
}
