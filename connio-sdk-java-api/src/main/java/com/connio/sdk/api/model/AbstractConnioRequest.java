package com.connio.sdk.api.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public abstract class AbstractConnioRequest implements ConnioRequest {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        metaData.setVersion("v1");
        metaData.setContentType("application/json");
    }

}
