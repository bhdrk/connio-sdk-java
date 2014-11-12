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
public class UpdateDeviceByCIDRequest extends DeviceRequest<UpdateDeviceResponse> {
    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notNull(deviceCid, "DeviceCid");
        Asserts.notEmpty(deviceCid.getCid(), "Cid");
        Asserts.notEmpty(deviceCid.getProfileName(), "ProfileName");
        Asserts.notNull(deviceCid.getCidType(), "CidType");
        Asserts.notNull(device, "Device");

        metaData.setMethod(PUT);
        metaData.addPath("/{profile-name}/{cid-type}/{cid}");
        metaData.addPathParam("profile-name", deviceCid.getProfileName());
        metaData.addPathParam("cid-type", deviceCid.getCidType().toString());
        metaData.addPathParam("cid", deviceCid.getCid());
        metaData.setRequestContent(device);
    }

    private Cid deviceCid;

    private Device device;

    public UpdateDeviceByCIDRequest() {
    }

    public UpdateDeviceByCIDRequest(Cid deviceCid, Device device) {
        this.deviceCid = deviceCid;
        this.device = device;
    }

    public Cid getDeviceCid() {
        return deviceCid;
    }

    public void setDeviceCid(Cid deviceCid) {
        this.deviceCid = deviceCid;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
