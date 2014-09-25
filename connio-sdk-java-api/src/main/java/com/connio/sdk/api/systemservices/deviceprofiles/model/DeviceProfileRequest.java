package com.connio.sdk.api.systemservices.deviceprofiles.model;

import com.connio.sdk.api.model.AbstractConnioRequest;
import com.connio.sdk.api.model.RequestMetaData;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 25.09.2014
 */
public abstract class DeviceProfileRequest<RS extends DeviceProfileResponse> extends AbstractConnioRequest<RS> {
    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);
        metaData.addPath("/_deviceprofiles");
    }
}
