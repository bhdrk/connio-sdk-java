package com.connio.sdk.api.systemservices.deviceprofiles.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 25.09.2014
 */
public class UpdateDeviceProfileResponse extends DeviceProfileEndpointResponse<DeviceProfileDetails> {

    private DeviceProfileDetails result;

    @Override
    public DeviceProfileDetails getResult() {
        return result;
    }

    @Override
    public void setResult(DeviceProfileDetails result) {
        this.result = result;
    }
}
