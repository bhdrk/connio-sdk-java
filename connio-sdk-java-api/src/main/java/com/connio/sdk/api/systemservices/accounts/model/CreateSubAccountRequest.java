package com.connio.sdk.api.systemservices.accounts.model;

import com.connio.sdk.api.model.Method;
import com.connio.sdk.api.model.RequestMetaData;

import static com.connio.sdk.api.model.Method.POST;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public class CreateSubAccountRequest extends AccountEndpointRequest {

    @Override
    public RequestMetaData getRequestMetaData() {
        RequestMetaData data = super.getRequestMetaData();
        data.setMethod(POST);
        return data;
    }

    /**
     * TODO: javadoc
     */
    private SubAccount subAccount;

    public SubAccount getSubAccount() {
        return subAccount;
    }

    public void setSubAccount(SubAccount subAccount) {
        this.subAccount = subAccount;
    }
}
