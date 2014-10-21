package com.connio.sdk.api.dataservices;

import com.connio.sdk.api.core.ConnioClient;
import com.connio.sdk.api.dataservices.model.DataFeed;
import com.connio.sdk.api.dataservices.model.DataFeedDetails;
import com.connio.sdk.api.dataservices.model.DataPointResultSet;
import com.connio.sdk.api.dataservices.model.DataQuery;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.exception.ConnioServiceException;

/**
 * TODO: javadoc
 * <p/>
 * Created by bdirik on 16.10.2014.
 */
public interface IDataClient extends ConnioClient {

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
    public DataPointResultSet getData(String appNameOrSid, String channelNameOrSid, DataQuery dataQuery)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param appNameOrSid
     * @param dataFeed
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    public DataFeedDetails sendData(String appNameOrSid, DataFeed dataFeed)
            throws ConnioServiceException, ConnioClientException;

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
    public DataFeedDetails sendData(String appNameOrSid, String channelNameOrSid, DataFeed dataFeed)
            throws ConnioServiceException, ConnioClientException;
}
