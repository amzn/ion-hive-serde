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

import org.apache.hadoop.hive.serde2.objectinspector.primitive.BooleanObjectInspector;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfoFactory;
import org.apache.hadoop.io.BooleanWritable;
import software.amazon.ion.IonBool;
import software.amazon.ion.IonValue;

/**
 * Adapts an {@link IonBool} into a domain that Hives understands
 */
public class IonBooleanToBooleanObjectInspector extends AbstractIonPrimitiveJavaObjectInspector implements BooleanObjectInspector {

    IonBooleanToBooleanObjectInspector() {
        super(TypeInfoFactory.booleanTypeInfo);
    }

    @Override
    public Object getPrimitiveWritableObject(final Object o) {
        if (isIonNull((IonValue) o)) return null;

        IonBool ionValue = (IonBool) o;
        return new BooleanWritable(ionValue.booleanValue());
    }

    @Override
    public boolean get(Object o) {
        return (boolean) getPrimitiveJavaObject(o);
    }

    @Override
    public Object getPrimitiveJavaObject(final Object o) {
        if (isIonNull((IonValue) o)) return null;

        IonBool ionValue = (IonBool) o;
        return ionValue.booleanValue() ? Boolean.TRUE : Boolean.FALSE;
    }
}

