package com.connio.sdk.http.utils;

import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.model.AbstractConnioRequest;
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
    public HttpEntity convert(AbstractConnioRequest request) {
        try {
            ContentType httpContentType = ContentType.create(request.getRequestMetaData().getContentType(), Consts.UTF_8);
            return new StringEntity(JSON.toString(request.getContent()), httpContentType);
        } catch (Exception e) {
            throw new ConnioClientException(e);
        }
    }
}
