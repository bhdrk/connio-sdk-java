package com.connio.sdk.api.systemservices.datachannels.model;

import com.connio.sdk.api.model.Deleted;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public class DeleteDataChannelResponse extends DataChannelEndpointResponse<Deleted> {

    private Deleted result;

    @Override
    public Deleted getResult() {
        return result;
    }

    @Override
    public void setResult(Deleted result) {
        this.result = result;
    }
}
