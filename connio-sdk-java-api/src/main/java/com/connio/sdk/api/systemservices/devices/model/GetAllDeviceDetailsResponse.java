package com.connio.sdk.api.systemservices.devices.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 29.09.2014
 */
public class GetAllDeviceDetailsResponse extends DeviceEndpointResponse<DeviceResultSet> {

    private DeviceResultSet result;

    @Override
    public DeviceResultSet getResult() {
        return result;
    }

    @Override
    public void setResult(DeviceResultSet result) {
        this.result = result;
    }
}
