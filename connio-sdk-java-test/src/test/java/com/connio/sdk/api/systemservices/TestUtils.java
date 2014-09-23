package com.connio.sdk.api.systemservices;


import com.connio.sdk.api.utils.Asserts;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 23.09.2014
 */
public class TestUtils {

    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("-yy-MM-dd-HH-mm-ss-SSS");

    private static final int MAX_LENGTH = 32;

    public static String createNewName(String prefix) {
        String suffix = FORMATTER.format(new Date());
        int maxLength = MAX_LENGTH - suffix.length();
        Asserts.maxSize(prefix, maxLength, "Prefix");
        return prefix + suffix;
    }
}
