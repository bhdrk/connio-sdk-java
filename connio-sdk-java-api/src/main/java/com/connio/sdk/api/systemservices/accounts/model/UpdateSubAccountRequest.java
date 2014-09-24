package com.connio.sdk.api.systemservices.accounts.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import java.util.HashMap;
import java.util.Map;

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

        Map<String, String> pathParams = new HashMap<String, String>(1);
        pathParams.put("account-sid", sid);

        metaData.setMethod(PUT);
        metaData.setPath("{account-sid}");
        metaData.setPathParams(pathParams);

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
