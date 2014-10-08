package com.connio.sdk.api.systemservices.deviceprofiles.model;

import com.connio.sdk.api.model.Deleted;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 25.09.2014
 */
public class DeleteDeviceProfileResponse extends DeviceProfileEndpointResponse<Deleted> {

    private Deleted result;

    @Override
    public Deleted getResult() {
        return result;
    }

    @Override
    public void setResult(Deleted result) {
        this.result = result;
    }
}
