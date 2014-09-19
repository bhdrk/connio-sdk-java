package com.connio.sdk.http.utils;

import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.model.ConnioRequest;
import com.connio.sdk.api.model.RequestMetaData;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
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
            RequestMetaData metaData = request.getRequestMetaData();
            ContentType httpContentType = ContentType.create(metaData.getContentType(), Consts.UTF_8);
            return new StringEntity(JSON.toString(metaData.getRequestContent()), httpContentType);
        } catch (Exception e) {
            throw new ConnioClientException(e);
        }
    }
}
