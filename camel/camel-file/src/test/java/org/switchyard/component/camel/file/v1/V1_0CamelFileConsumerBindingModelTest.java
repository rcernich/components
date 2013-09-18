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
 */
public class V1_0CamelFileConsumerBindingModelTest extends V1CamelFileConsumerBindingModelTest {

    private static final String CAMEL_XML = "/v1/switchyard-file-binding-consumer-beans-1.0.xml";
    private static final String CAMEL_URI = "file:///input/directory?delay=1000&initialDelay=500&maxMessagesPerPoll=100&delete=false&" +
            "recursive=true&noop=false&preMove=.inProgress&move=.done&moveFailed=.failed&" +
            "include=*.csv&exclude=*.xml&idempotent=true&sortBy=file:name&" +
            "readLock=fileLock&readLockTimeout=10&readLockCheckInterval=1000&" +
            "startingDirectoryMustExist=false&directoryMustExist=true&doneFileName=done";

    public V1_0CamelFileConsumerBindingModelTest() {
        super(CAMEL_XML, Constants.FILE_NAMESPACE_V1_0);
    }

    @Override
    protected String createEndpointUri() {
        return CAMEL_URI;
    }

}
