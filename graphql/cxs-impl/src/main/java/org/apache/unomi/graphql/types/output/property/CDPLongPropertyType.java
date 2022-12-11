/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.unomi.graphql.types.output.property;

import com.google.common.base.Strings;
import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;
import org.apache.unomi.api.PropertyType;
import org.apache.unomi.api.query.NumericRange;
import org.apache.unomi.graphql.types.output.CDPPropertyInterface;

import static org.apache.unomi.graphql.types.output.property.CDPLongPropertyType.TYPE_NAME;

@GraphQLName(TYPE_NAME)
public class CDPLongPropertyType extends CDPPropertyType implements CDPPropertyInterface {

    public static final String TYPE_NAME = "CDP_LongProperty";

    public static final String UNOMI_TYPE = "long";

    public CDPLongPropertyType(final PropertyType type) {
        super(type);
    }

    @GraphQLField
    public Long minValue() {
        if (type == null) {
            return null;
        }
        final NumericRange defaultRange = getDefaultNumericRange();
        final Double from = defaultRange != null ? defaultRange.getFrom() : null;
        return from != null ? from.longValue() : null;
    }

    @GraphQLField
    public Long maxValue() {
        final NumericRange defaultRange = getDefaultNumericRange();
        final Double to = defaultRange != null ? defaultRange.getTo() : null;
        return to != null ? to.longValue() : null;
    }

    @GraphQLField
    public Long defaultValue() {
        if (type == null) {
            return null;
        }
        final String defaultValue = type.getDefaultValue();
        return !Strings.isNullOrEmpty(defaultValue) ? Long.valueOf(defaultValue) : null;
    }
}
