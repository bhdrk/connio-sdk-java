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
public class UpdateDeviceByCIDRequest extends DeviceEndpointRequest<UpdateDeviceResponse> {
    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notNull(cid, "Cid");
        Asserts.notEmpty(cid.getCid(), "Cid");
        Asserts.notEmpty(cid.getProfileName(), "ProfileName");
        Asserts.notNull(cid.getCidType(), "CidType");
        Asserts.notNull(device, "Device");

        metaData.setMethod(PUT);
        metaData.addPath("/{profile-name}/{cid-type}/{cid}");
        metaData.addPathParam("profile-name", cid.getProfileName());
        metaData.addPathParam("cid-type", cid.getProfileName());
        metaData.addPathParam("cid", cid.getProfileName());
        metaData.setRequestContent(device);
    }

    private Cid cid;

    private Device device;

    public UpdateDeviceByCIDRequest() {
    }

    public UpdateDeviceByCIDRequest(Cid cid, Device device) {
        this.cid = cid;
        this.device = device;
    }

    public Cid getCid() {
        return cid;
    }

    public void setCid(Cid cid) {
        this.cid = cid;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
