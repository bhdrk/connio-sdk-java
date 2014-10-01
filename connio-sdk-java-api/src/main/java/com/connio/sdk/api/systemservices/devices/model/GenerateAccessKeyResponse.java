package com.connio.sdk.api.systemservices.devices.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 29.09.2014
 */
public class GenerateAccessKeyResponse extends DeviceEndpointResponse<DeviceAccessKey> {

    private DeviceAccessKey result;

    @Override
    public Class<DeviceAccessKey> getResultType() {
        return DeviceAccessKey.class;
    }

    @Override
    public DeviceAccessKey getResult() {
        return result;
    }

    @Override
    public void setResult(DeviceAccessKey result) {
        this.result = result;
    }
}
