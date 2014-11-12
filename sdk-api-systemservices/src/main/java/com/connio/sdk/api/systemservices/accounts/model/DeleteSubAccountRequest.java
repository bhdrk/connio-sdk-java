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
public class DeleteSubAccountRequest extends AccountRequest<DeleteSubAccountResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(accountSid, "AccountSid");

        metaData.setMethod(DELETE);
        metaData.addPath("/{account-sid}");
        metaData.addPathParam("account-sid", accountSid);
    }

    /**
     * TODO: javadoc
     */
    private String accountSid;

    public DeleteSubAccountRequest() {
    }

    public DeleteSubAccountRequest(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }
}
