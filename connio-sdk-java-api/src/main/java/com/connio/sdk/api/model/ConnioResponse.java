package com.connio.sdk.api.model;

import java.io.Serializable;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public interface ConnioResponse<T> extends Serializable {

    /**
     * TODO: javadoc
     *
     * @return
     */
    public Class<T> getResultType();

    /**
     * TODO: javadoc
     *
     * @return
     */
    public T getResult();

    /**
     * TODO: javadoc
     *
     * @param result
     */
    public void setResult(T result);
}
