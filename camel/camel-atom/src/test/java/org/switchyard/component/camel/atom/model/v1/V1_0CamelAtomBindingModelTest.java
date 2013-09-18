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
package org.switchyard.component.camel.atom.model.v1;

import java.text.ParseException;
import java.util.Map;

import org.switchyard.component.camel.atom.model.Constants;
import org.switchyard.component.camel.common.model.AdditionalUriParametersModel;

/**
 * Test of atom binding model.
 */
public class V1_0CamelAtomBindingModelTest extends V1CamelAtomBindingModelTest {

    private static final String CAMEL_XML = "/v1/switchyard-atom-binding-1.0.xml";

    private static final String CAMEL_URI = 
        "atom://file:///dev/null?feedHeader=true&filter=true&lastUpdate=2011-01-01T12:00:00"
        + "&sortEntries=true&splitEntries=true&throttleEntries=true"
        + "&delay=15000&initialDelay=20000&useFixedDelay=true";

    public V1_0CamelAtomBindingModelTest() throws ParseException {
        super(CAMEL_XML, Constants.ATOM_NAMESPACE_V1_0);
    }

    @Override
    protected AdditionalUriParametersModel createAdditionalUriParametersModel(String namespace,
            Map<String, String> parameters) {
        return null;
    }

    @Override
    protected String createEndpointUri() {
        return CAMEL_URI;
    }

}
