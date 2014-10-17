package com.connio.sdk.http.json;

import com.connio.sdk.api.exception.ConnioClientException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.io.InputStream;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 16.09.2014
 */
public class JSON {
    private static final ObjectMapper MAPPER = createObjectMapper();

    private static ObjectMapper createObjectMapper() {
        SimpleModule enumModule = new SimpleModule();
        enumModule.setDeserializers(new CustomDeserializers());

        return new ObjectMapper()
                .setPropertyNamingStrategy(new CustomPropertyNamingStrategy())
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .registerModule(enumModule);
    }

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

    public static <T> T fromStream(InputStream contentStream, Class<T> resultType) {
        try {
            return MAPPER.readValue(contentStream, resultType);
        } catch (IOException e) {
            throw new ConnioClientException("JSON Processing Error", e);
        }
    }

    public static JsonNode toNodeTree(String content) {
        return toNodeTree(content, false);
    }

    public static JsonNode toNodeTree(String content, boolean ignoreParsingException) {
        try {
            return MAPPER.readTree(content);
        } catch (JsonParseException e) {
            if (ignoreParsingException) {
                return null;
            }
            throw new ConnioClientException("JSON Parse Error", e);
        } catch (IOException e) {
            throw new ConnioClientException("JSON Processing Error", e);
        }
    }
}
