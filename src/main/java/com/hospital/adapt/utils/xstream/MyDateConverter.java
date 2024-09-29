
package com.hospital.adapt.utils.xstream;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyDateConverter implements Converter {
    private static final List<String> formarts = new ArrayList<String>(4);
    private static Logger log = LoggerFactory.getLogger(MyDateConverter.class);

    static {
        formarts.add("yyyy-MM");
        formarts.add("yyyy-MM-dd");
        formarts.add("yyyy-MM-dd hh:mm");
        formarts.add("yyyy-MM-dd hh:mm:ss");
        formarts.add("MM/dd/yyyy");
        formarts.add("MM/dd/yyyy hh:mm:ss");
    }

    public MyDateConverter() {
    }

    @Override
    public boolean canConvert(Class clazz) {
        return Date.class.isAssignableFrom(clazz);
    }

    @Override
    public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext arg2) {
        DateFormat formatter = DateFormat.getDateInstance(DateFormat.FULL, null);
        writer.setValue(formatter.format(value));
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext arg1) {
        Object obj = null;

        try {
            String source = reader.getValue();
            if (null != source && source.trim().length() > 0) {
                if (source.matches("^\\d{4}-\\d{1,2}$")) {
                    obj = parseDate(source, formarts.get(0));
                } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")) {
                    obj = parseDate(source, formarts.get(1));
                } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")) {
                    obj = parseDate(source, formarts.get(2));
                } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
                    obj = parseDate(source, formarts.get(3));
                } else if (source.matches("^\\d{1,2}/\\d{1,2}/\\d{4}$")) {
                    obj = parseDate(source, formarts.get(4));
                } else if (source.matches("^\\d{1,2}/\\d{1,2}/\\d{4} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
                    obj = parseDate(source, formarts.get(5));
                } else {
                    throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
                }
            }
        } catch (Exception e) {
            log.error(e.getStackTrace().toString());
        }

        return obj;
    }

    public Date parseDate(String dateStr, String format) {
        Date date = null;

        try {
            DateFormat dateFormat = new SimpleDateFormat(format);
            date = (Date) dateFormat.parse(dateStr);
        } catch (Exception e) {
            log.error(e.getStackTrace().toString());
        }

        return date;
    }
}
