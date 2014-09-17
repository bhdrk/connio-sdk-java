package com.connio.sdk.api.systemservices.accounts.model;

import com.connio.sdk.api.model.RequestMetaData;

import java.util.HashMap;
import java.util.Map;

import static com.connio.sdk.api.model.Method.PUT;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public class UpdateSubAccountRequest extends AccountEndpointRequest {

    @Override
    public RequestMetaData getRequestMetaData() {
        Map<String, String> pathParams = new HashMap<String, String>(1);
        pathParams.put("account-sid", getSid());

        RequestMetaData data = super.getRequestMetaData();
        data.setMethod(PUT);
        data.setPath("{account-sid}");
        data.setPathParams(pathParams);

        return data;
    }

    private String sid;

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

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
