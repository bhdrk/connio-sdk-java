package com.connio.sdk.api.dataservices;

import com.connio.sdk.api.core.AbstractClient;
import com.connio.sdk.api.dataservices.model.*;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.exception.ConnioServiceException;

/**
 * TODO: javadoc
 * <p/>
 * Created by bdirik on 16.10.2014.
 */
public class DataClient extends AbstractClient implements IDataClient {

    /**
     * TODO: javadoc
     */
    public DataClient(String credentialsProfile) {
        super(credentialsProfile);
    }

    /**
     * TODO: javadoc
     *
     * @param appNameOrSid
     * @param channelNameOrSid
     * @param dataQuery
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    @Override
    public DataPointResultSet getData(String appNameOrSid, String channelNameOrSid, DataQuery dataQuery)
            throws ConnioServiceException, ConnioClientException {
        return execute(new GetDataFromChannelRequest(appNameOrSid, channelNameOrSid, dataQuery));
    }

    /**
     * TODO: javadoc
     *
     * @param appNameOrSid
     * @param dataFeed
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    @Override
    public DataFeedDetails sendData(String appNameOrSid, DataFeed dataFeed) throws ConnioServiceException, ConnioClientException {
        return execute(new SendDataToAppRequest(appNameOrSid, dataFeed));
    }

    /**
     * TODO: javadoc
     *
     * @param appNameOrSid
     * @param channelNameOrSid
     * @param dataFeed
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    @Override
    public DataFeedDetails sendData(String appNameOrSid, String channelNameOrSid, DataFeed dataFeed)
            throws ConnioServiceException, ConnioClientException {
        return execute(new SendDataToChannelRequest(appNameOrSid, channelNameOrSid, dataFeed));
    }
}
