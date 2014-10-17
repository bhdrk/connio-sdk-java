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
public class UpdateDeviceBySIDRequest extends DeviceEndpointRequest<UpdateDeviceResponse> {
    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(sid, "Sid");
        Asserts.notNull(device, "Device");

        metaData.setMethod(PUT);
        metaData.addPath("/{sid}");
        metaData.addPathParam("sid", sid);
        metaData.setRequestContent(device);
    }

    private String sid;

    private Device device;

    public UpdateDeviceBySIDRequest() {
    }

    public UpdateDeviceBySIDRequest(String sid, Device device) {
        this.sid = sid;
        this.device = device;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
