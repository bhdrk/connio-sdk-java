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
public class CreateAuthenticationTokenRequest extends AccountRequest<CreateAuthenticationTokenResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(accountSid, "AccountSid");

        metaData.setMethod(POST);
        metaData.addPath("/{account-sid}/_authtoken");
        metaData.addPathParam("account-sid", accountSid);
        metaData.setRequestContent(new Sid(accountSid));
    }

    /**
     * TODO: javadoc
     */
    private String accountSid;

    public CreateAuthenticationTokenRequest() {
    }

    public CreateAuthenticationTokenRequest(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }
}
