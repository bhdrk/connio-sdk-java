package com.connio.sdk.api.systemservices.devices.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.POST;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 29.09.2014
 */
public class RegenerateAccessKeyBySIDRequest extends DeviceRequest<RegenerateAccessKeyResponse> {
    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(deviceSid, "DeviceSid");

        metaData.setMethod(POST);
        metaData.addPath("/{device-sid}/_keys");
        metaData.addPathParam("device-sid", deviceSid);
    }

    private String deviceSid;

    public RegenerateAccessKeyBySIDRequest() {
    }

    public RegenerateAccessKeyBySIDRequest(String deviceSid) {
        this.deviceSid = deviceSid;
    }

    public String getDeviceSid() {
        return deviceSid;
    }

    public void setDeviceSid(String deviceSid) {
        this.deviceSid = deviceSid;
    }
}
