
package com.hospital.adapt.utils.xstream;

import com.thoughtworks.xstream.converters.basic.DoubleConverter;

public class MyDoubleConverter extends DoubleConverter {
    @Override
    public boolean canConvert(Class type) {
        return type.equals(double.class) || type.equals(Double.class);
    }

    @Override
    public Object fromString(String str) {
        if (str == null || str.trim().length() == 0) {
            return null;
        }

        return super.fromString(str.trim());
    }
}
