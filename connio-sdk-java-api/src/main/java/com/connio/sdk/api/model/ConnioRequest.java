package com.connio.sdk.api.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 18.09.2014
 */
public interface ConnioRequest<T> {

    /**
     * TODO: javadoc
     *
     * @return
     */
    public Class<T> getContentType();

    /**
     * TODO: javadoc
     *
     * @return
     */
    public T getContent();

    /**
     * TODO: javadoc
     *
     * @return
     */
    RequestMetaData getRequestMetaData();
}
