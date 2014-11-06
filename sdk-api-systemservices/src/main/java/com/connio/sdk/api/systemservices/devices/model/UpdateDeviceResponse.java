package com.connio.sdk.api.systemservices.devices.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 29.09.2014
 */
public class UpdateDeviceResponse extends DeviceResponse<DeviceDetails> {

    private DeviceDetails result;

    @Override
    public DeviceDetails getResult() {
        return result;
    }

    @Override
    public void setResult(DeviceDetails result) {
        this.result = result;
    }
}
