package com.connio.sdk.api.systemservices.apps.model;

import com.connio.sdk.api.model.AbstractConnioRequest;
import com.connio.sdk.api.model.RequestMetaData;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public abstract class AppEndpointRequest<RS extends AppEndpointResponse> extends AbstractConnioRequest<RS> {
    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);
        metaData.addPath("/_apps");
    }
}
