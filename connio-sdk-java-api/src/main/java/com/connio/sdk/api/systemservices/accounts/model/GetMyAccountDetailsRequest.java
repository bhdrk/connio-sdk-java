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
    protected void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        metaData.setPath("/me");
        metaData.setMethod(GET);
    }

    public GetMyAccountDetailsRequest() {
    }
}
