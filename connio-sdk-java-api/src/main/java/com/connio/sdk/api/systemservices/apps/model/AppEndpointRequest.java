package com.connio.sdk.api.systemservices.apps.model;

import com.connio.sdk.api.model.ConnioRequest;
import com.connio.sdk.api.model.RequestMetaData;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public abstract class AppEndpointRequest extends ConnioRequest {
    @Override
    public RequestMetaData getRequestMetaData() {
        RequestMetaData data = super.getRequestMetaData();
        data.setEndpoint("_apps");
        return data;
    }
}
