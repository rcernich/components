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
package org.switchyard.component.common.composer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.switchyard.Context;
import org.switchyard.Property;
import org.switchyard.Scope;
import org.switchyard.config.model.composer.ContextMapperModel;
import org.switchyard.config.model.composer.StaticPropertiesModel;
import org.switchyard.config.model.composer.StaticPropertyModel;

/**
 * Base class for ContextMapper, no-op'ing the required methods in case the extender only needs to override one of them.
 *
 * @param <D> the type of binding data
 *
 * @author David Ward &lt;<a href="mailto:dward@jboss.org">dward@jboss.org</a>&gt; &copy; 2011 Red Hat Inc.
 */
public class BaseContextMapper<D extends BindingData> implements ContextMapper<D> {

    private ContextMapperModel _model;
    private List<Property> _staticInProperties = Collections.emptyList();
    private List<Property> _staticOutProperties = Collections.emptyList();
    private List<Property> _staticExchangeProperties = Collections.emptyList();

    /**
     * {@inheritDoc}
     */
    @Override
    public ContextMapperModel getModel() {
        return _model;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setModel(ContextMapperModel model) {
        _model = model;
        loadStaticProperties();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mapFrom(D source, Context context) throws Exception {
        // No-op; override if desired.
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mapTo(Context context, D target) throws Exception {
        // No-op; override if desired.
    }

    @Override
    public List<Property> getStaticInMessageProperties() {
        return _staticInProperties;
    }

    @Override
    public List<Property> getStaticOutMessageProperties() {
        return _staticOutProperties;
    }

    @Override
    public List<Property> getStaticExchangeProperties() {
        return _staticExchangeProperties;
    }

    private void loadStaticProperties() {
        _staticInProperties = loadProperties(_model == null ? null : _model.getStaticInMessageProperties(), Scope.MESSAGE);
        _staticOutProperties = loadProperties(_model == null ? null : _model.getStaticOutMessageProperties(), Scope.MESSAGE);
        _staticExchangeProperties = loadProperties(_model == null ? null : _model.getStaticExchangeProperties(),
                Scope.EXCHANGE);
    }

    private List<Property> loadProperties(StaticPropertiesModel propertiesModel, Scope scope) {
        if (propertiesModel == null) {
            return Collections.emptyList();
        }
        final List<StaticPropertyModel> propertyModels = propertiesModel.getStaticProperties();
        final List<Property> retVal = new ArrayList<Property>(propertyModels.size());
        for (StaticPropertyModel propertyModel : propertyModels) {
            if (propertyModel == null || propertyModel.getName() == null) {
                continue;
            }
            retVal.add(new StaticProperty(propertyModel.getName(), propertyModel.getValue(), scope, propertyModel.getLabels()));
        }
        return retVal;
    }

    private static final class StaticProperty implements Property {
        private String _name;
        private String _value;
        private Scope _scope;
        private Set<String> _labels;

        private StaticProperty(String name, String value, Scope scope, Set<String> labels) {
            super();
            _name = name;
            _value = value;
            _scope = scope;
            _labels = labels == null ? Collections.<String> emptySet() : Collections.unmodifiableSet(labels);
        }

        @Override
        public Scope getScope() {
            return _scope;
        }

        @Override
        public String getName() {
            return _name;
        }

        @Override
        public Object getValue() {
            return _value;
        }

        @Override
        public Set<String> getLabels() {
            return _labels;
        }

        @Override
        public Property addLabels(String... labels) {
            return this;
        }

        @Override
        public Property addLabels(Set<String> labels) {
            return this;
        }

        @Override
        public Property removeLabels(String... labels) {
            return this;
        }

        @Override
        public boolean hasLabel(String label) {
            return _labels.contains(label);
        }

    }
}
