package com.connio.sdk.api.systemservices.accounts.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.systemservices.users.model.UserRequest;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.GET;

/**
 * Created by bdirik on 13.11.2014.
 */
public class GetUsersOfAccountRequest extends AccountRequest<GetUsersOfAccountResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(accountSid, "AccountSid");

        metaData.setMethod(GET);
        metaData.addPath("/{sid}/_users");
        metaData.addPathParam("sid", accountSid);
    }

    private String accountSid;

    public GetUsersOfAccountRequest() {
    }

    public GetUsersOfAccountRequest(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }
}
