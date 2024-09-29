
package com.hospital.adapt.utils.xstream;

import com.thoughtworks.xstream.converters.basic.IntConverter;

public class MyIntConverter extends IntConverter {

    @Override
    public boolean canConvert(Class type) {
        return type.equals(int.class) || type.equals(Integer.class);
    }

    @Override
    public Object fromString(String str) {
        if (str == null || str.trim().length() == 0) {
            return null;
        }

        return super.fromString(str.trim());
    }

}
