package com.connio.sdk.api.utils;

import com.connio.sdk.api.exception.ConnioClientException;

public class Asserts {

    public static void check(final boolean expression, final String message) {
        if (!expression) {
            throw new ConnioClientException(message);
        }
    }

    public static void notNull(final Object object, final String name) {
        if (object == null) {
            throw new ConnioClientException(name + " is null");
        }
    }

    public static void notEmpty(final String s, final String name) {
        if (TypeUtils.isEmpty(s)) {
            throw new ConnioClientException(name + " is empty");
        }
    }

}