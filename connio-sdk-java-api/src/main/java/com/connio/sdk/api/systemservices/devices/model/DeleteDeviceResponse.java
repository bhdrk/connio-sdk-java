package com.connio.sdk.api.systemservices.devices.model;

import com.connio.sdk.api.model.Deleted;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 29.09.2014
 */
public class DeleteDeviceResponse extends DeviceEndpointResponse<Deleted> {

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
