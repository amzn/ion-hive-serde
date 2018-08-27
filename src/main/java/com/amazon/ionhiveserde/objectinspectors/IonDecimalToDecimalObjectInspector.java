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

import org.apache.hadoop.hive.common.type.HiveDecimal;
import org.apache.hadoop.hive.serde2.io.HiveDecimalWritable;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.HiveDecimalObjectInspector;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfoFactory;
import software.amazon.ion.IonDecimal;
import software.amazon.ion.IonValue;

/**
 * Adapts an {@link IonDecimal} into a domain that Hives understands
 */
public class IonDecimalToDecimalObjectInspector extends AbstractIonPrimitiveJavaObjectInspector implements HiveDecimalObjectInspector {

    IonDecimalToDecimalObjectInspector() {
        super(TypeInfoFactory.decimalTypeInfo);
    }

    @Override
    public HiveDecimalWritable getPrimitiveWritableObject(final Object o) {
        if (isIonNull((IonValue) o)) return null;

        IonDecimal ionValue = (IonDecimal) o;
        return new HiveDecimalWritable(HiveDecimal.create(ionValue.bigDecimalValue()));
    }

    @Override
    public HiveDecimal getPrimitiveJavaObject(final Object o) {
        if (isIonNull((IonValue) o)) return null;

        IonDecimal ionValue = (IonDecimal) o;
        return HiveDecimal.create(ionValue.bigDecimalValue());
    }
}