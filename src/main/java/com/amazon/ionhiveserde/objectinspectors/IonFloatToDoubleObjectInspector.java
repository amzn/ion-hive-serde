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

package com.amazon.ionhiveserde.objectinspectors;

import org.apache.hadoop.hive.serde2.objectinspector.primitive.DoubleObjectInspector;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfoFactory;
import org.apache.hadoop.io.DoubleWritable;
import software.amazon.ion.IonFloat;
import software.amazon.ion.IonValue;

/**
 * Adapts an {@link IonFloat} into a domain that Hives understands
 */
public class IonFloatToDoubleObjectInspector extends AbstractIonPrimitiveJavaObjectInspector implements DoubleObjectInspector {

    IonFloatToDoubleObjectInspector() {
        super(TypeInfoFactory.doubleTypeInfo);
    }

    @Override
    public Object getPrimitiveWritableObject(final Object o) {
        if (isIonNull((IonValue) o)) return null;

        IonFloat ionValue = (IonFloat) o;
        return new DoubleWritable(ionValue.doubleValue());
    }

    @Override
    public double get(Object o) {
        return (double) getPrimitiveJavaObject(o);
    }

    @Override
    public Object getPrimitiveJavaObject(final Object o) {
        if (isIonNull((IonValue) o)) return null;

        IonFloat ionValue = (IonFloat) o;
        return ionValue.doubleValue();
    }
}