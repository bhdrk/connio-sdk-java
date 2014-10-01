package com.connio.sdk.api.systemservices.accounts.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.DELETE;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public class DeleteSubAccountRequest extends AccountEndpointRequest<DeleteSubAccountResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(sid, "Sid");

        metaData.setMethod(DELETE);
        metaData.addPath("/{account-sid}");
        metaData.addPathParam("account-sid", sid);
    }

    /**
     * TODO: javadoc
     */
    private String sid;

    public DeleteSubAccountRequest() {
    }

    public DeleteSubAccountRequest(String sid) {
        this.sid = sid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
