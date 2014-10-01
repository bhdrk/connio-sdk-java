package com.connio.sdk.api.systemservices.accounts.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.GET;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 11.09.2014
 */
public class GetSubAccountDetailsRequest extends AccountEndpointRequest<GetSubAccountDetailsResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(sid, "Sid");

        metaData.addPath("/{account-sid}");
        metaData.addPathParam("account-sid", sid);
        metaData.setMethod(GET);
    }

    /**
     * TODO: javadoc
     */
    private String sid;

    public GetSubAccountDetailsRequest() {
    }

    public GetSubAccountDetailsRequest(String sid) {
        this.sid = sid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
