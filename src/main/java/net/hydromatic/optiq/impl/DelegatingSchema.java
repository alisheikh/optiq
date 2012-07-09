/*
// Licensed to Julian Hyde under one or more contributor license
// agreements. See the NOTICE file distributed with this work for
// additional information regarding copyright ownership.
//
// Julian Hyde licenses this file to you under the Apache License,
// Version 2.0 (the "License"); you may not use this file except in
// compliance with the License. You may obtain a copy of the License at:
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
*/
package net.hydromatic.optiq.impl;

import net.hydromatic.linq4j.expressions.Expression;
import net.hydromatic.optiq.Member;
import net.hydromatic.optiq.Schema;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Implementation of {@link net.hydromatic.optiq.Schema} that delegates to an
 * underlying schema.
 *
 * @author jhyde
 */
public class DelegatingSchema implements Schema {
    protected final Schema schema;

    /**
     * Creates a DelegatingSchema.
     *
     * @param schema Underlying schema
     */
    public DelegatingSchema(Schema schema) {
        this.schema = schema;
    }

    public Type getType() {
        return schema.getType();
    }

    public List<Member> getMembers(String name) {
        return schema.getMembers(name);
    }

    public Expression getMemberExpression(
        Expression schemaExpression, Member member, List<Expression> arguments)
    {
        return schema.getMemberExpression(
            schemaExpression, member, arguments);
    }

    public Object getSubSchemaInstance(
        Object schemaInstance,
        String subSchemaName,
        Schema subSchema)
    {
        return schema.getSubSchemaInstance(
            schemaInstance, null, subSchema);
    }

    public Schema getSubSchema(String name) {
        return schema.getSubSchema(name);
    }

    public Expression getSubSchemaExpression(
        Expression schemaExpression, Schema schema, String name)
    {
        return schema.getSubSchemaExpression(schemaExpression, schema, name);
    }
}

// End DelegatingSchema.java
