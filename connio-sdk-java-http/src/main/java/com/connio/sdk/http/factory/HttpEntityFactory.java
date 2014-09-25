package com.connio.sdk.http.factory;

import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.model.ConnioRequest;
import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.TypeUtils;
import com.connio.sdk.http.httpentity.HttpEntityConverter;
import com.connio.sdk.http.httpentity.JSONEntityConverter;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 17.09.2014
 */
public class HttpEntityFactory {
    private static HttpEntityFactory instance = new HttpEntityFactory();
    private static Map<String, HttpEntityConverter> supportedContentTypes;

    static {
        supportedContentTypes = new HashMap<String, HttpEntityConverter>();
        supportedContentTypes.put(ContentType.APPLICATION_JSON.getMimeType(), new JSONEntityConverter());
    }

    public static HttpEntity create(ConnioRequest request, RequestMetaData metaData) {
        return instance.doCreate(request, metaData);
    }

    private HttpEntity doCreate(ConnioRequest request, RequestMetaData metaData) {
        return getConverter(request, metaData).convert(request, metaData);
    }

    private HttpEntityConverter getConverter(ConnioRequest request, RequestMetaData metaData) {
        String contentType = metaData.getContentType();
        if (TypeUtils.isNotEmpty(contentType) && supportedContentTypes.containsKey(contentType)) {
            return supportedContentTypes.get(contentType);
        }
        throw new ConnioClientException("Unsupported content type: " + contentType);
    }
}
