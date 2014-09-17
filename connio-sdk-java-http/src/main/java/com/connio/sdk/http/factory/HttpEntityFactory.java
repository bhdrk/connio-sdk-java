package com.connio.sdk.http.factory;

import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.model.ConnioRequest;
import com.connio.sdk.api.utils.TypeUtils;
import com.connio.sdk.http.utils.HttpEntityConverter;
import com.connio.sdk.http.utils.JSONEntityConverter;
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

    public static HttpEntity create(ConnioRequest request) {
        return instance.doCreate(request);
    }

    private HttpEntity doCreate(ConnioRequest request) {
        return getConverter(request).convert(request);
    }

    private HttpEntityConverter getConverter(ConnioRequest request) {
        String contentType = request.getRequestMetaData().getContentType();
        if (TypeUtils.isNotEmpty(contentType) && supportedContentTypes.containsKey(contentType)) {
            return supportedContentTypes.get(contentType);
        }
        throw new ConnioClientException("Unsupported content type: " + contentType);
    }
}
