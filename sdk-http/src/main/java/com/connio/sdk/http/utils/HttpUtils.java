package com.connio.sdk.http.utils;

import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.model.ConnioRequest;
import com.connio.sdk.api.model.ConnioResponse;
import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.http.internal.ClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.Iterator;
import java.util.Map;

import static com.connio.sdk.api.utils.TypeUtils.isEmpty;
import static com.connio.sdk.api.utils.TypeUtils.isNotEmpty;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 16.09.2014
 */
public class HttpUtils {
    private static final Logger LOG = LoggerFactory.getLogger(HttpUtils.class);

    @SuppressWarnings("unchecked")
    public static <RS extends ConnioResponse> Class<RS> resolveResponseType(ConnioRequest<RS> request) {
        return (Class<RS>) TypeResolver.resolveRawArgument(ConnioRequest.class, request.getClass());
    }

    @SuppressWarnings("unchecked")
    public static <RT> Class<RT> resolveResultType(ConnioResponse<RT> response) {
        return (Class<RT>) TypeResolver.resolveRawArgument(ConnioResponse.class, response.getClass());
    }

    /**
     * Build URI for related request.
     *
     * @return
     */
    public static URL buildURL(ClientConfig clientConfig, RequestMetaData metaData) {

        try {
            URI uri = new URI(
                    clientConfig.getServiceURI().getScheme(),
                    clientConfig.getServiceURI().getUserInfo(),
                    clientConfig.getServiceURI().getHost(),
                    clientConfig.getServiceURI().getPort(),
                    clientConfig.getServiceURI().getPath() + buildPath(metaData),
                    buildQuery(metaData),
                    null
            );
            return uri.toURL();
        } catch (URISyntaxException e) {
            LOG.warn(e.getMessage(), e);
            throw new ConnioClientException("URI Syntax Error", e);
        } catch (MalformedURLException e) {
            LOG.warn(e.getMessage(), e);
            throw new ConnioClientException("URI Syntax Error", e);
        }
    }

    public static String buildQuery(RequestMetaData metaData) {
        Map<String, String> queryParams = metaData.getQueryParams();

        if (isEmpty(queryParams))
            return null;

        StringBuilder sb = new StringBuilder();

        for (Iterator<Map.Entry<String, String>> iterator = queryParams.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<String, String> queryParam = iterator.next();
            String key = queryParam.getKey();
            String value = queryParam.getValue();

            if (isNotEmpty(key)) {
                sb.append(key);
                if (isNotEmpty(value)) {
                    sb.append("=").append(encodeUrlParam(value));
                }
                if (iterator.hasNext()) {
                    sb.append("&");
                }
            }
        }

        return sb.toString();
    }

    public static String buildPath(RequestMetaData metaData) {
        String path = metaData.getPath();

        if (isEmpty(path))
            return null;

        Map<String, String> pathParams = metaData.getPathParams();

        if (isNotEmpty(pathParams)) {
            for (Map.Entry<String, String> pathParam : pathParams.entrySet()) {
                String key = pathParam.getKey();
                String value = pathParam.getValue();

                if (isNotEmpty(key) && isNotEmpty(value)) {
                    path = path.replace("{" + key + "}", encodeUrlParam(value));
                }
            }
        }

        if (path.charAt(0) != '/') {
            path = '/' + path;
        }

        return path;
    }

    public static String encodeUrlParam(String param) {
        try {
            return URLEncoder.encode(param, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOG.warn(e.getMessage(), e);
            return null;
        }
    }
}
