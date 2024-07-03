package hs.springboot.example.utility;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CompareUtils {


    public static int compare(Object value, Object anotherValue) {
        if (value == null || anotherValue == null) {
            throw new IllegalArgumentException(String.format("Null value not allowed [%s,%s]", value, anotherValue));
        }
        if (!value.getClass().isAssignableFrom(anotherValue.getClass())) {
            throw new IllegalArgumentException("Different types cannot compared");
        }

        if (value instanceof Integer v) {
            return v.compareTo((Integer) anotherValue);
        } else if (value instanceof Double v) {
            return v.compareTo((Double) anotherValue);
        } else if (value instanceof Long v) {
            return v.compareTo((Long) anotherValue);
        } else if (value instanceof Float v) {
            return v.compareTo((Float) anotherValue);
        } else if (value instanceof BigInteger v) {
            return v.compareTo((BigInteger) anotherValue);
        } else if (value instanceof BigDecimal v) {
            return v.compareTo((BigDecimal) anotherValue);
        } else if (value instanceof String v) {
            return v.compareTo((String) anotherValue);
        } else {
            throw new IllegalArgumentException(
                    String.format("This type is not supported. [%s]", value.getClass().getName()));
        }
    }

}
