package com.connio.sdk.http.utils;

import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.model.ConnioRequest;
import org.apache.http.HttpEntity;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.StringEntity;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 17.09.2014
 */
public class JSONEntityConverter implements HttpEntityConverter {
    @Override
    public HttpEntity convert(ConnioRequest request) {
        try {
            StringEntity stringEntity = new StringEntity(JSON.toString(request), request.getRequestMetaData().getContentType());
            return new BufferedHttpEntity(stringEntity);
        } catch (Exception e) {
            throw new ConnioClientException(e);
        }
    }
}
