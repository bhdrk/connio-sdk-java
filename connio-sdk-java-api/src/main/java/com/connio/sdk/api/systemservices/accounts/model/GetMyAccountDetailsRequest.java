package com.connio.sdk.api.systemservices.accounts.model;

import com.connio.sdk.api.model.RequestMetaData;

import static com.connio.sdk.api.model.Method.GET;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 15.09.2014
 */
public class GetMyAccountDetailsRequest extends AccountEndpointRequest {
    @Override
    public RequestMetaData getRequestMetaData() {
        RequestMetaData data = super.getRequestMetaData();
        data.setPath("/me");
        data.setMethod(GET);
        return data;
    }
}
