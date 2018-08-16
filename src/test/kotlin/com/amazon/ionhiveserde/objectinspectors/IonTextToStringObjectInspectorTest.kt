/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at:
 *
 *      http://aws.amazon.com/apache2.0/
 *
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */

package com.amazon.ionhiveserde.objectinspectors

import org.junit.Test
import kotlin.test.assertEquals

class IonTextToStringObjectInspectorTest : AbstractIonPrimitiveJavaObjectInspectorTest() {

    override val subject = IonTextToStringObjectInspector()

    @Test
    fun getPrimitiveWritableObjectWithString() {
        val string = ION.newString("some string")

        val actual = subject.getPrimitiveWritableObject(string)
        assertEquals("some string", actual.toString())
    }

    @Test
    fun getPrimitiveWritableObjectWithSymbol() {
        val symbol = ION.newSymbol("some string")

        val actual = subject.getPrimitiveWritableObject(symbol)
        assertEquals("some string", actual.toString())
    }

    @Test
    fun getPrimitiveJavaObjectWithString() {
        val string = ION.newString("some string")

        val actual = subject.getPrimitiveJavaObject(string)
        assertEquals("some string", actual)
    }

    @Test
    fun getPrimitiveJavaObjectWithSymbol() {
        val symbol = ION.newSymbol("some string")

        val actual = subject.getPrimitiveJavaObject(symbol)
        assertEquals("some string", actual)
    }
}