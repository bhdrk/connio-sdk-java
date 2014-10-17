package com.connio.sdk.api.systemservices.users.model;

import com.connio.sdk.api.model.AbstractConnioRequest;
import com.connio.sdk.api.model.RequestMetaData;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 11.09.2014
 */
public abstract class UserEndpointRequest<RS extends UserEndpointResponse> extends AbstractConnioRequest<RS> {
    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);
        metaData.addPath("/_users");
    }
}
