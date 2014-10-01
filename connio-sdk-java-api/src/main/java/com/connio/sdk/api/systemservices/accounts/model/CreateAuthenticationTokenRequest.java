package com.connio.sdk.api.systemservices.accounts.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.model.Sid;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.POST;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public class CreateAuthenticationTokenRequest extends AccountEndpointRequest<CreateAuthenticationTokenResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(sid, "Sid");

        metaData.setMethod(POST);
        metaData.addPath("/{account-sid}/_authtoken");
        metaData.addPathParam("account-sid", sid);
        metaData.setRequestContent(new Sid(sid));
    }

    /**
     * TODO: javadoc
     */
    private String sid;

    public CreateAuthenticationTokenRequest() {
    }

    public CreateAuthenticationTokenRequest(String sid) {
        this.sid = sid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
