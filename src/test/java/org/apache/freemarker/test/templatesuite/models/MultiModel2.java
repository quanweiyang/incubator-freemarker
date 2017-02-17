/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.freemarker.test.templatesuite.models;

import java.util.Iterator;
import java.util.List;

import org.apache.freemarker.core.model.TemplateMethodModel;
import org.apache.freemarker.core.model.TemplateScalarModel;
import org.apache.freemarker.core.model.impl.SimpleScalar;

/**
 * Testcase to see how FreeMarker deals with multiple Template models.
 */
public class MultiModel2 implements TemplateScalarModel, TemplateMethodModel {

    /**
     * Returns the scalar's value as a String.
     *
     * @return the String value of this scalar.
     */
    @Override
    public String getAsString() {
        return "Model2 is alive!";
    }

    /**
     * Executes a method call.
     *
     * @param arguments a <tt>List</tt> of <tt>String</tt> objects containing the values
     * of the arguments passed to the method.
     * @return the <tt>TemplateModel</tt> produced by the method, or null.
     */
    @Override
    public Object exec(List arguments) {
        StringBuilder  aResults = new StringBuilder( "Arguments are:<br />" );
        Iterator    iList = arguments.iterator();

        while ( iList.hasNext() ) {
            aResults.append( (String) iList.next() );
            aResults.append( "<br />" );
        }

        return new SimpleScalar( aResults.toString() );
    }
}
