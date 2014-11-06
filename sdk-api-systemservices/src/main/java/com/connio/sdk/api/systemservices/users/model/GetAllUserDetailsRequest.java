package com.connio.sdk.api.systemservices.users.model;

import com.connio.sdk.api.model.RequestMetaData;

import static com.connio.sdk.api.model.Method.GET;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 23.09.2014
 */
public class GetAllUserDetailsRequest extends UserRequest<GetAllUserDetailsResponse> {
    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);
        metaData.setMethod(GET);
    }
}
