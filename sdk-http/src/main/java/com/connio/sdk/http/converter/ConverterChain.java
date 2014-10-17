package com.connio.sdk.http.converter;

import com.connio.sdk.api.exception.ConnioClientException;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 02.10.2014
 */
public class ConverterChain implements Converter {

    private static final ConverterChain instance = new ConverterChain();

    public static ConverterChain instance() {
        return instance;
    }

    private Map<String, Converter> map = new HashMap<>();

    public ConverterChain() {
        registerConverter(new JSONConverter());
    }

    private void registerConverter(Converter converter) {
        for (String type : converter.getSupportedTypes()) {
            map.put(type.toLowerCase(Locale.ENGLISH), converter);
        }
    }

    @Override
    public String from(String contentType, Object content) {
        return getConverter(contentType).from(contentType, content);
    }

    @Override
    public <T> T to(String contentType, InputStream is, Class<T> toClass) {
        return getConverter(contentType).to(contentType, is, toClass);
    }

    @Override
    public String[] getSupportedTypes() {
        Set<String> keys = map.keySet();
        return keys.toArray(new String[keys.size()]);
    }

    private Converter getConverter(String contentType) {
        String type = transform(contentType);
        if (!map.containsKey(type)) {
            throw new ConnioClientException("Unsupported content type:" + contentType);
        }
        return map.get(type);
    }

    private String transform(String type) {
        int indexOf = type.indexOf(";");
        if (indexOf != -1) {
            type = type.substring(0, indexOf);
        }
        return type.toLowerCase(Locale.ENGLISH);
    }
}
