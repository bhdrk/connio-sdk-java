package com.connio.sdk.api.systemservices.devices.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.PUT;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 29.09.2014
 */
public class UpdateDeviceBySIDRequest extends DeviceRequest<UpdateDeviceResponse> {
    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(deviceSid, "DeviceSid");
        Asserts.notNull(device, "Device");

        metaData.setMethod(PUT);
        metaData.addPath("/{device-sid}");
        metaData.addPathParam("device-sid", deviceSid);
        metaData.setRequestContent(device);
    }

    private String deviceSid;

    private Device device;

    public UpdateDeviceBySIDRequest() {
    }

    public UpdateDeviceBySIDRequest(String deviceSid, Device device) {
        this.deviceSid = deviceSid;
        this.device = device;
    }

    public String getDeviceSid() {
        return deviceSid;
    }

    public void setDeviceSid(String deviceSid) {
        this.deviceSid = deviceSid;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
