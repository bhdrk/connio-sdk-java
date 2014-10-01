package com.connio.sdk.api.systemservices.devices.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.GET;
import static com.connio.sdk.api.model.Method.POST;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 29.09.2014
 */
public class GetAccessKeyByCIDRequest extends DeviceEndpointRequest<GetAccessKeyResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notNull(cid, "Cid");
        Asserts.notEmpty(cid.getCid(), "Cid");
        Asserts.notEmpty(cid.getProfileName(), "ProfileName");
        Asserts.notNull(cid.getCidType(), "CidType");

        metaData.setMethod(GET);
        metaData.addPath("/{profile-name}/{cid-type}/{cid}/_keys");
        metaData.addPathParam("profile-name", cid.getProfileName());
        metaData.addPathParam("cid-type", cid.getCidType().toString());
        metaData.addPathParam("cid", cid.getCid());
    }

    private Cid cid;

    public GetAccessKeyByCIDRequest() {
    }

    public GetAccessKeyByCIDRequest(Cid cid) {
        this.cid = cid;
    }

    public Cid getCid() {
        return cid;
    }

    public void setCid(Cid cid) {
        this.cid = cid;
    }
}
