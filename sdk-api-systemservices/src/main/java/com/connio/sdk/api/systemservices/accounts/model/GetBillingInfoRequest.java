package com.connio.sdk.api.systemservices.accounts.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.GET;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public class GetBillingInfoRequest extends AccountRequest<GetBillingInfoResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(accountSid, "AccountSid");

        metaData.setMethod(GET);
        metaData.addPath("/{account-sid}/_billinginfo");
        metaData.addPathParam("account-sid", accountSid);
    }

    /**
     * TODO: javadoc
     */
    private String accountSid;

    public GetBillingInfoRequest() {
    }

    public GetBillingInfoRequest(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }
}
