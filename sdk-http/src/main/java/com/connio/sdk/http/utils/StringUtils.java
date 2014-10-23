package com.connio.sdk.http.utils;

/**
 * Created by bdirik on 23.10.2014.
 */
public class StringUtils {

    public static boolean startsWithIgnoreCase(String str1, String str2) {
        return (str1.length() > str2.length() && str2.equalsIgnoreCase(str1.substring(0, str2.length())));
    }

}
