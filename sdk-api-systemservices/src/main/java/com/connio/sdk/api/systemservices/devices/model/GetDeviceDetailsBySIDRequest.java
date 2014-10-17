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
public class GetDeviceDetailsBySIDRequest extends DeviceEndpointRequest<GetDeviceDetailsResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(sid, "Sid");

        metaData.setMethod(GET);
        metaData.addPath("/{sid}");
        metaData.addPathParam("sid", sid);
    }

    private String sid;

    public GetDeviceDetailsBySIDRequest() {
    }

    public GetDeviceDetailsBySIDRequest(String sid) {
        this.sid = sid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
