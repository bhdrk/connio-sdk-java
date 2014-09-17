package com.connio.sdk.http.utils;

import com.connio.sdk.api.exception.ConnioClientException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 16.09.2014
 */
public class JSON {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static String toString(Object obj) {
        try {
            return MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new ConnioClientException("JSON Processing Error", e);
        }
    }

    public static <T> T fromString(String content, Class<T> resultType) {
        try {
            return MAPPER.readValue(content, resultType);
        } catch (IOException e) {
            throw new ConnioClientException("JSON Processing Error", e);
        }
    }
}
