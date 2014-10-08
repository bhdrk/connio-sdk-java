package com.connio.sdk.api.systemservices.deviceprofiles.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 25.09.2014
 */
public class GetAllDeviceProfileDetailsResponse extends DeviceProfileEndpointResponse<DeviceProfileResultSet> {

    private DeviceProfileResultSet result;

    @Override
    public DeviceProfileResultSet getResult() {
        return result;
    }

    @Override
    public void setResult(DeviceProfileResultSet result) {
        this.result = result;
    }
}
