package com.connio.sdk.api.systemservices.devices.model;

import com.connio.sdk.api.model.AbstractConnioRequest;
import com.connio.sdk.api.model.RequestMetaData;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 29.09.2014
 */
public abstract class DeviceEndpointRequest<RS extends DeviceEndpointResponse> extends AbstractConnioRequest<RS> {
    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);
        metaData.addPath("/_devices");
    }
}
