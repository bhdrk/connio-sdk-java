package com.connio.sdk.api.systemservices.accounts.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.POST;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public class CreateSubAccountRequest extends AccountEndpointRequest<CreateSubAccountResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notNull(subAccount, "SubAccount");

        metaData.setMethod(POST);
        metaData.setRequestContent(subAccount);
    }

    /**
     * TODO: javadoc
     */
    private SubAccount subAccount;

    public CreateSubAccountRequest() {
    }

    public CreateSubAccountRequest(SubAccount subAccount) {
        this.subAccount = subAccount;
    }

    public SubAccount getSubAccount() {
        return subAccount;
    }

    public void setSubAccount(SubAccount subAccount) {
        this.subAccount = subAccount;
    }
}
