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
public class UpdateSubAccountRequest extends AccountRequest<UpdateSubAccountResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notNull(subAccount, "SubAccount");
        Asserts.notEmpty(accountSid, "AccountSid");

        metaData.setMethod(PUT);
        metaData.addPath("/{account-sid}");
        metaData.addPathParam("account-sid", accountSid);
        metaData.setRequestContent(subAccount);
    }

    /**
     * TODO: javadoc
     */
    private String accountSid;

    /**
     * TODO: javadoc
     */
    private SubAccount subAccount;

    public UpdateSubAccountRequest() {
    }

    public UpdateSubAccountRequest(String accountSid, SubAccount subAccount) {
        this.accountSid = accountSid;
        this.subAccount = subAccount;
    }

    public SubAccount getSubAccount() {
        return subAccount;
    }

    public void setSubAccount(SubAccount subAccount) {
        this.subAccount = subAccount;
    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }
}
