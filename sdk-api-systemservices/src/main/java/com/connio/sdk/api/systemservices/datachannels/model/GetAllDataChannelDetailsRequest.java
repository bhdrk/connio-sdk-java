package com.connio.sdk.api.systemservices.datachannels.model;

import com.connio.sdk.api.model.RequestMetaData;

import static com.connio.sdk.api.model.Method.GET;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public class GetAllDataChannelDetailsRequest extends DataChannelRequest<GetAllDataChannelDetailsResponse> {
    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);
        metaData.setMethod(GET);
    }

    public GetAllDataChannelDetailsRequest() {
        super();
    }

    public GetAllDataChannelDetailsRequest(String appSidOrName) {
        super(appSidOrName);
    }
}
