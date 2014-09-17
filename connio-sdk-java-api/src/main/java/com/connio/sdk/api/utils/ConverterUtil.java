package com.connio.sdk.api.utils;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 16.09.2014
 */
public class ConverterUtil {
    public static String convert(String value) {
        return value == null ? "" : value;
    }

    public static String convert(Enum<?> value) {
        return value == null ? "" : value.name().toLowerCase();
    }
}
