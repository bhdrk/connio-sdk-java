package com.connio.sdk.api.model;

import java.io.Serializable;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 18.09.2014
 */
public interface ConnioRequest<RS extends ConnioResponse> extends Serializable {
    /**
     * TODO: javadoc
     *
     * @param metaData
     */
    void loadMetaData(RequestMetaData metaData);
}
