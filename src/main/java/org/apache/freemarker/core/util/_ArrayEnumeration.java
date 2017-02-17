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

package org.apache.freemarker.core.util;

import java.util.Enumeration;
import java.util.NoSuchElementException;

/** Don't use this; used internally by FreeMarker, might changes without notice. */
public class _ArrayEnumeration implements Enumeration {

    private final Object[] array;
    private final int size;
    private int nextIndex;

    public _ArrayEnumeration(Object[] array, int size) {
        this.array = array;
        this.size = size;
        this.nextIndex = 0;
    }

    @Override
    public boolean hasMoreElements() {
        return nextIndex < size;
    }

    @Override
    public Object nextElement() {
        if (nextIndex >= size) {
            throw new NoSuchElementException();
        }
        return array[nextIndex++];
    }

}
