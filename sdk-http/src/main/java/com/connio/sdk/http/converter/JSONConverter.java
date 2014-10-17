package com.connio.sdk.http.converter;

import com.connio.sdk.http.json.JSON;

import java.io.InputStream;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 02.10.2014
 */
public class JSONConverter implements Converter {

    private static final String[] SUPPORTED_TYPES = new String[]{"application/json"};

    @Override
    public String from(String contentType, Object content) {
        return JSON.toString(content);
    }

    @Override
    public <T> T to(String contentType, InputStream in, Class<T> toClass) {
        return JSON.fromStream(in, toClass);
    }

    @Override
    public String[] getSupportedTypes() {
        return SUPPORTED_TYPES;
    }
}
