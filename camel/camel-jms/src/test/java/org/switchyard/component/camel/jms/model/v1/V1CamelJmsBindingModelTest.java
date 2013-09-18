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

import static junit.framework.Assert.assertEquals;

import org.apache.camel.component.jms.JmsEndpoint;
import org.switchyard.component.camel.config.test.v1.V1BaseCamelServiceBindingModelTest;
import org.switchyard.component.camel.jms.model.Constants;

/**
 * Test for {@link V1CamelJmsBindingModel}.
 * 
 * @author Lukasz Dywicki
 */
public class V1CamelJmsBindingModelTest extends V1BaseCamelServiceBindingModelTest<V1CamelJmsBindingModel, JmsEndpoint> {

    private static final String CAMEL_XML = "/v1/switchyard-jms-binding-beans.xml";

    private static String TOPIC = "esb_in_topic";
    private static String CONNECTION_FACTORY = "connFactory";
    private static String USERNAME = "camel";
    private static String PASSWORD = "isMyFriend";
    private static String CLIENT_ID = "esb_in";
    private static String DURABLE_SUBSCRIPTION_NAME = "esb_in_sub";
    private static Integer CONCURRENT_CONSUMERS = 5;
    private static Integer MAX_CONCURRENT_CONSUMERS = 15;
    private static Boolean DISABLE_REPLY_TO = true;
    private static Boolean PRESERVE_MESSAGE_QOS = true;
    private static Boolean DELIVERY_PERSISTENT = false;
    private static Integer PRIORITY = 9;
    private static Boolean EXPLICIT_QOS_ENABLED = true;
    private static String REPLY_TO = "esb_out";
    private static String REPLY_TO_TYPE= "Shared";
    private static Integer REQUEST_TIMEOUT = 300;
    private static String SELECTOR = "DEST='ESB'";
    private static Integer TIME_TO_LIVE = 3600;
    private static Boolean TRANSACTED = true;
    private static String ACKNOWLEDGEMENTMODE_NAME = "AUTO_ACKNOWLEDGE";
    private static Integer ACKNOWLEDGEMENTMODE = -1;
    
    private static final String CAMEL_URI = "jms:topic:esb_in_topic?connectionFactory=connFactory&" +
        "username=camel&password=isMyFriend&clientId=esb_in&durableSubscriptionName=esb_in_sub&" +
        "concurrentConsumers=5&maxConcurrentConsumers=15&disableReplyTo=true&preserveMessageQos=true&" +
        "deliveryPersistent=false&priority=9&explicitQosEnabled=true&replyTo=esb_out&replyToType=Shared&" +
        "requestTimeout=300&selector=DEST='ESB'&timeToLive=3600&transacted=true&acknowledgementModeName=AUTO_ACKNOWLEDGE&acknowledgementMode=-1";

    private final String _namespaceUri;

    public V1CamelJmsBindingModelTest() {
        this(CAMEL_XML, Constants.JMS_NAMESPACE_V1);
    }

    protected V1CamelJmsBindingModelTest(String testConfigPath, String namespaceUri) {
        super(JmsEndpoint.class, testConfigPath);
        _namespaceUri = namespaceUri;
        setSkipCamelEndpointTesting(true);
    }

    @Override
    protected V1CamelJmsBindingModel createTestModel() {
        return (V1CamelJmsBindingModel) new V1CamelJmsBindingModel(V1CamelJmsBindingModel.JMS, _namespaceUri)
            .setTopic(TOPIC)
            .setConnectionFactory(CONNECTION_FACTORY)
            .setUsername(USERNAME)
            .setPassword(PASSWORD)
            .setClientId(CLIENT_ID)
            .setDurableSubscriptionName(DURABLE_SUBSCRIPTION_NAME)
            .setConcurrentConsumers(CONCURRENT_CONSUMERS)
            .setMaxConcurrentConsumers(MAX_CONCURRENT_CONSUMERS)
            .setDisableReplyTo(DISABLE_REPLY_TO)
            .setPreserveMessageQos(PRESERVE_MESSAGE_QOS)
            .setDeliveryPersistent(DELIVERY_PERSISTENT)
            .setPriority(PRIORITY)
            .setExplicitQosEnabled(EXPLICIT_QOS_ENABLED)
            .setReplyTo(REPLY_TO)
            .setReplyToType(REPLY_TO_TYPE)
            .setRequestTimeout(REQUEST_TIMEOUT)
            .setSelector(SELECTOR)
            .setTimeToLive(TIME_TO_LIVE)
            .setTransacted(TRANSACTED)
            .setAcknowledgementModeName(ACKNOWLEDGEMENTMODE_NAME)
            .setAcknowledgementMode(ACKNOWLEDGEMENTMODE);
    }

    @Override
    protected void createModelAssertions(V1CamelJmsBindingModel model) {
        assertEquals(TOPIC, model.getTopic());
        assertEquals(CONNECTION_FACTORY, model.getConnectionFactory());
        assertEquals(USERNAME, model.getUsername());
        assertEquals(PASSWORD, model.getPassword());
        assertEquals(CLIENT_ID, model.getClientId());
        assertEquals(DURABLE_SUBSCRIPTION_NAME, model.getDurableSubscriptionName());
        assertEquals(CONCURRENT_CONSUMERS, model.getConcurrentConsumers());
        assertEquals(MAX_CONCURRENT_CONSUMERS, model.getMaxConcurrentConsumers());
        assertEquals(DISABLE_REPLY_TO, model.isDisableReplyTo());
        assertEquals(PRESERVE_MESSAGE_QOS, model.isPreserveMessageQos());
        assertEquals(DELIVERY_PERSISTENT, model.isDeliveryPersistent());
        assertEquals(PRIORITY, model.getPriority());
        assertEquals(EXPLICIT_QOS_ENABLED, model.isExplicitQosEnabled());
        assertEquals(REPLY_TO, model.getReplyTo());
        assertEquals(REPLY_TO_TYPE, model.getReplyToType());
        assertEquals(REQUEST_TIMEOUT, model.getRequestTimeout());
        assertEquals(SELECTOR, model.getSelector());
        assertEquals(TIME_TO_LIVE, model.getTimeToLive());
        assertEquals(TRANSACTED, model.isTransacted());
        assertEquals(ACKNOWLEDGEMENTMODE_NAME, model.getAcknowledgementModeName());
        assertEquals(ACKNOWLEDGEMENTMODE, model.getAcknowledgementMode());
    }

    @Override
    protected String createEndpointUri() {
        return CAMEL_URI;
    }

}
