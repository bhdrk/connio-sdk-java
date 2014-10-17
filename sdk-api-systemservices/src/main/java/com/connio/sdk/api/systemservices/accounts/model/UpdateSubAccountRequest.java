package com.connio.sdk.api.systemservices.accounts.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.PUT;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public class UpdateSubAccountRequest extends AccountEndpointRequest<UpdateSubAccountResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notNull(subAccount, "SubAccount");
        Asserts.notEmpty(sid, "Sid");

        metaData.setMethod(PUT);
        metaData.addPath("/{account-sid}");
        metaData.addPathParam("account-sid", sid);
        metaData.setRequestContent(subAccount);
    }

    /**
     * TODO: javadoc
     */
    private String sid;

    /**
     * TODO: javadoc
     */
    private SubAccount subAccount;

    public UpdateSubAccountRequest() {
    }

    public UpdateSubAccountRequest(String sid, SubAccount subAccount) {
        this.sid = sid;
        this.subAccount = subAccount;
    }

    public SubAccount getSubAccount() {
        return subAccount;
    }

    public void setSubAccount(SubAccount subAccount) {
        this.subAccount = subAccount;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
