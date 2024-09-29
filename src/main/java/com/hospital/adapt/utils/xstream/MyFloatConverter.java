
package com.hospital.adapt.utils.xstream;

import com.thoughtworks.xstream.converters.basic.FloatConverter;

public class MyFloatConverter extends FloatConverter {
    @Override
    public boolean canConvert(Class type) {
        return type.equals(float.class) || type.equals(Float.class);
    }

    @Override
    public Object fromString(String str) {
        if (str == null || str.trim().length() == 0) {
            return null;
        }

        return super.fromString(str.trim());
    }
}
