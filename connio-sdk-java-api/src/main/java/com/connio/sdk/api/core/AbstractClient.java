package com.connio.sdk.api.core;

import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.exception.ConnioServiceException;
import com.connio.sdk.api.model.ConnioRequest;
import com.connio.sdk.api.model.ConnioResponse;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 29.09.2014
 */
public abstract class AbstractClient implements ConnioClient {
    private ConnioClientTransformer context;

    protected AbstractClient() {
        context = ConnioClientTransformerProvider.get();
    }

    protected <RT, RS extends ConnioResponse<RT>> RT execute(ConnioRequest<RS> request)
            throws ConnioServiceException, ConnioClientException {
        RS response = context.execute(request);
        return response != null ? response.getResult() : null;
    }
}
