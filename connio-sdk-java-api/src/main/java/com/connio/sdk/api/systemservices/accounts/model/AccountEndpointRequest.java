package com.connio.sdk.api.systemservices.accounts.model;

import com.connio.sdk.api.model.ConnioRequest;
import com.connio.sdk.api.model.RequestMetaData;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public abstract class AccountEndpointRequest extends ConnioRequest {
    @Override
    public RequestMetaData getRequestMetaData() {
        RequestMetaData data = super.getRequestMetaData();
        data.setEndpoint("_accounts");
        return data;
    }
}
