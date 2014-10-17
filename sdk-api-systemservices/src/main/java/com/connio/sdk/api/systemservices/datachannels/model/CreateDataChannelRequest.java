package com.connio.sdk.api.systemservices.datachannels.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.POST;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public class CreateDataChannelRequest extends DataChannelEndpointRequest<CreateDataChannelResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notNull(dataChannel, "DataChannel");

        metaData.setMethod(POST);
        metaData.setRequestContent(dataChannel);
    }

    private DataChannel dataChannel;

    public CreateDataChannelRequest() {
        super();
    }

    public CreateDataChannelRequest(String appId, DataChannel dataChannel) {
        super(appId);
        this.dataChannel = dataChannel;
    }

    public DataChannel getDataChannel() {
        return dataChannel;
    }

    public void setDataChannel(DataChannel dataChannel) {
        this.dataChannel = dataChannel;
    }
}
