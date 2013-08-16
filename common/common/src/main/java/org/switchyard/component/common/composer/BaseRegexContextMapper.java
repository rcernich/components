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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.xml.namespace.QName;

import org.switchyard.Context;
import org.switchyard.Property;
import org.switchyard.common.lang.Strings;
import org.switchyard.common.xml.XMLHelper;
import org.switchyard.label.Label;

/**
 * Base class for RegexContextMapper; adds the regex pattern matching ability.
 *
 * @param <D> the type of binding data
 *
 * @author David Ward &lt;<a href="mailto:dward@jboss.org">dward@jboss.org</a>&gt; &copy; 2012 Red Hat Inc.
 */
public class BaseRegexContextMapper<D extends BindingData> extends BaseContextMapper<D> implements RegexContextMapper<D> {

    private final List<Pattern> _includes = new ArrayList<Pattern>();
    private final List<Pattern> _excludes = new ArrayList<Pattern>();
    private final List<Pattern> _includeNamespaces = new ArrayList<Pattern>();
    private final List<Pattern> _excludeNamespaces = new ArrayList<Pattern>();

    private void setPatternList(String regexs, List<Pattern> patternList) {
        Set<String> regexSet = Strings.uniqueSplitTrimToNull(regexs, ",");
        List<Pattern> tmpList = new ArrayList<Pattern>();
        for (String regex : regexSet) {
            try {
                Pattern pattern = Pattern.compile(regex);
                tmpList.add(pattern);
            } catch (PatternSyntaxException pse) {
                throw new IllegalArgumentException("\"" + regex + "\" is not a valid regex pattern: " + pse.getMessage());
            }
        }
        synchronized (patternList) {
            patternList.clear();
            patternList.addAll(tmpList);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ContextMapper<D> setIncludes(String includes) {
        setPatternList(includes, _includes);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ContextMapper<D> setExcludes(String excludes) {
        setPatternList(excludes, _excludes);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ContextMapper<D> setIncludeNamespaces(String includeNamespaces) {
        setPatternList(includeNamespaces, _includeNamespaces);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ContextMapper<D> setExcludeNamespaces(String excludeNamespaces) {
        setPatternList(excludeNamespaces, _excludeNamespaces);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean matches(String name) {
        return matches(XMLHelper.createQName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean matches(QName qname) {
        return qname != null && matches(qname.getLocalPart(), _includes, _excludes) && matches(qname.getNamespaceURI(), _includeNamespaces, _excludeNamespaces);
    }

    private boolean matches(String test, List<Pattern> includes, List<Pattern> excludes) {
        boolean green = false;
        boolean red = false;
        for (Pattern include : includes) {
            if (include.matcher(test).matches()) {
                green = true;
                break;
            } else {
                red = true;
            }
        }
        boolean matches = green || !red;
        if (matches) {
            green = false;
            red = false;
            for (Pattern exclude : excludes) {
                if (!exclude.matcher(test).matches()) {
                    green = true;
                    break;
                } else {
                    red = true;
                }
            }
            matches = green || !red;
        }
        return matches;
    }

    /**
     * Add the properties to the context.
     * 
     * @param context the context to which the properties should be added.
     * @param properties the properties to add.
     * @param defaultLabels the default set of labels to add to all properties.
     */
    protected void applyStaticProperties(Context context, List<Property> properties, String[] defaultLabels) {
        if (context == null || properties == null || properties.size() == 0) {
            return;
        }
        for (Property property : properties) {
            // TODO: should we be filtering these, even if the user specified them manually?
            if (matches(property.getName()) && context.getProperty(property.getName(), property.getScope()) == null) {
                final Set<String> labels = loadLabels(property);
                final Property staticProperty = context.setProperty(property.getName(), property.getValue(), property.getScope());
                if (labels != null) {
                    staticProperty.addLabels(labels);
                }
                // TODO: should we only add defaults if labels are null? 
                if (defaultLabels != null) {
                    staticProperty.addLabels(defaultLabels);
                }
            }
        }
    }

    private Set<String> loadLabels(Property property) {
        final Set<String> rawLabels = property.getLabels();
        if (rawLabels == null || rawLabels.size() == 0) {
            return null;
        }
        final Set<String> convertedLabels = new HashSet<String>();
        for (String rawLabel : rawLabels) {
            rawLabel = Strings.trimToNull(rawLabel);
            if (rawLabel == null) {
                continue;
            }
            final String[] typeAndName = rawLabel.split(".");
            if (typeAndName.length == 2) {
                convertedLabels.add(Label.Util.toSwitchYardLabel(typeAndName[0], typeAndName[1]));
            } else {
                // TODO: log warning?
                if (typeAndName.length > 2) {
                    convertedLabels.add(rawLabel);
                }
            }
        }
        return convertedLabels.size() == 0 ? null : convertedLabels;
    }

}
