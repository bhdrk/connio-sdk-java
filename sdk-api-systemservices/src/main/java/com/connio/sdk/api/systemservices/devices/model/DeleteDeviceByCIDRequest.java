package com.connio.sdk.api.systemservices.devices.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.DELETE;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 29.09.2014
 */
public class DeleteDeviceByCIDRequest extends DeviceRequest<DeleteDeviceResponse> {
    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notNull(deviceCid, "DeviceCid");
        Asserts.notEmpty(deviceCid.getCid(), "Cid");
        Asserts.notEmpty(deviceCid.getProfileName(), "ProfileName");
        Asserts.notNull(deviceCid.getCidType(), "CidType");

        metaData.setMethod(DELETE);
        metaData.addPath("/{profile-name}/{cid-type}/{cid}");
        metaData.addPathParam("profile-name", deviceCid.getProfileName());
        metaData.addPathParam("cid-type", deviceCid.getCidType().toString());
        metaData.addPathParam("cid", deviceCid.getCid());
    }

    private Cid deviceCid;

    public DeleteDeviceByCIDRequest() {
    }

    public DeleteDeviceByCIDRequest(Cid deviceCid) {
        this.deviceCid = deviceCid;
    }

    public Cid getDeviceCid() {
        return deviceCid;
    }

    public void setDeviceCid(Cid deviceCid) {
        this.deviceCid = deviceCid;
    }
}
