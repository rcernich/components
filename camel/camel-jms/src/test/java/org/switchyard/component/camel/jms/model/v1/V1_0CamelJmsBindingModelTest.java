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
package org.switchyard.component.camel.jms.model.v1;

import org.switchyard.component.camel.jms.model.Constants;

/**
 * Test for {@link V1CamelJmsBindingModel}.
 */
public class V1_0CamelJmsBindingModelTest extends V1CamelJmsBindingModelTest {

    private static final String CAMEL_XML = "/v1/switchyard-jms-binding-beans-1.0.xml";

    private static final String CAMEL_URI = "jms:topic:esb_in_topic?connectionFactory=connFactory&" +
        "username=camel&password=isMyFriend&clientId=esb_in&durableSubscriptionName=esb_in_sub&" +
        "concurrentConsumers=5&maxConcurrentConsumers=15&disableReplyTo=true&preserveMessageQos=true&" +
        "deliveryPersistent=false&priority=9&explicitQosEnabled=true&replyTo=esb_out&replyToType=Shared&" +
        "requestTimeout=300&selector=DEST='ESB'&timeToLive=3600&transacted=true&acknowledgementModeName=AUTO_ACKNOWLEDGE&acknowledgementMode=-1";

    public V1_0CamelJmsBindingModelTest() {
        super(CAMEL_XML, Constants.JMS_NAMESPACE_V1_0);
    }

    @Override
    protected String createEndpointUri() {
        return CAMEL_URI;
    }

}
