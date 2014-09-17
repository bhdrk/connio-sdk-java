package com.connio.sdk.api.model;

import java.io.Serializable;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public abstract class ConnioRequest implements Serializable {

    public RequestMetaData getRequestMetaData() {
        RequestMetaData data = new RequestMetaData();
        data.setVersion("v1");
        data.setContentType("application/json");
        return data;
    }

}
