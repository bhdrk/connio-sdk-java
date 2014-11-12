package com.connio.sdk.api.systemservices.devices.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.GET;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 29.09.2014
 */
public class GetAccessKeyByCIDRequest extends DeviceRequest<GetAccessKeyResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notNull(deviceCid, "Cid");
        Asserts.notEmpty(deviceCid.getCid(), "Cid");
        Asserts.notEmpty(deviceCid.getProfileName(), "ProfileName");
        Asserts.notNull(deviceCid.getCidType(), "CidType");

        metaData.setMethod(GET);
        metaData.addPath("/{profile-name}/{cid-type}/{cid}/_keys");
        metaData.addPathParam("profile-name", deviceCid.getProfileName());
        metaData.addPathParam("cid-type", deviceCid.getCidType().toString());
        metaData.addPathParam("cid", deviceCid.getCid());
    }

    private Cid deviceCid;

    public GetAccessKeyByCIDRequest() {
    }

    public GetAccessKeyByCIDRequest(Cid deviceCid) {
        this.deviceCid = deviceCid;
    }

    public Cid getDeviceCid() {
        return deviceCid;
    }

    public void setDeviceCid(Cid deviceCid) {
        this.deviceCid = deviceCid;
    }
}
