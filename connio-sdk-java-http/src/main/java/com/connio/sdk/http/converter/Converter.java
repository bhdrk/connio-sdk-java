package com.connio.sdk.http.converter;

import java.io.InputStream;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 02.10.2014
 */
public interface Converter {

    /**
     * TODO: javadoc
     *
     * @param contentType
     * @param content
     * @return
     */
    public String from(String contentType, Object content);

    /**
     * TODO: javadoc
     *
     * @param contentType
     * @param toClass
     * @return
     */
    public <T> T to(String contentType, InputStream in, Class<T> toClass);

    /**
     * TODO: javadoc
     *
     * @return
     */
    public String[] getSupportedTypes();
}
