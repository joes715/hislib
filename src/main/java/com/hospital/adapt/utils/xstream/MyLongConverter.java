
package com.hospital.adapt.utils.xstream;

import com.thoughtworks.xstream.converters.basic.LongConverter;

public class MyLongConverter extends LongConverter {

    @Override
    public boolean canConvert(Class type) {
        return type.equals(long.class) || type.equals(Long.class);
    }

    @Override
    public Object fromString(String str) {
        if (str == null || str.trim().length() == 0) {
            return null;
        }

        return super.fromString(str.trim());
    }

}
