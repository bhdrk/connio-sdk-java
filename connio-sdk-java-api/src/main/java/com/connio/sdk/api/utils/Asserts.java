package com.connio.sdk.api.utils;

import com.connio.sdk.api.exception.ConnioClientException;

import java.util.Collection;
import java.util.Map;

public class Asserts {

    public static void check(final boolean expression, final String message) {
        if (!expression) {
            throw new ConnioClientException(message);
        }
    }

    public static void notNull(final Object object, final String name) {
        if (object == null) {
            throw new ConnioClientException(name + " is null.");
        }
    }

    public static void notEmpty(final String str, final String name) {
        if (TypeUtils.isEmpty(str)) {
            throw new ConnioClientException(name + " is empty.");
        }
    }

    public static void maxSize(String str, int maxLength, String name) {
        notEmpty(str, name);
        if (str.length() > maxLength) {
            throw new ConnioClientException(name + " is more than " + maxLength + ".");
        }
    }

    public static void maxSize(Collection<?> collection, int maxLength, String name) {
        notNull(collection, name);
        if (collection.size() > maxLength) {
            throw new ConnioClientException(name + " is more than " + maxLength + ".");
        }
    }

    public static void maxSize(Map<?, ?> map, int maxLength, String name) {
        notNull(map, name);
        if (map.size() > maxLength) {
            throw new ConnioClientException(name + " is more than " + maxLength);
        }
    }
}