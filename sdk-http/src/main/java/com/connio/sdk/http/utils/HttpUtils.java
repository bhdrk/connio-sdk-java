package com.connio.sdk.http.utils;

import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.model.ConnioRequest;
import com.connio.sdk.api.model.ConnioResponse;
import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.http.internal.ClientConfig;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
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
                    clientConfig.getProtocol(),
                    null,
                    clientConfig.getHost(),
                    clientConfig.getPort(),
                    buildPath(metaData),
                    buildQuery(metaData),
                    null
            );
            return uri.toURL();
        } catch (URISyntaxException e) {
            throw new ConnioClientException("URI Syntax Error", e);
        } catch (MalformedURLException e) {
            throw new ConnioClientException("URI Syntax Error", e);
        }
    }

    public static String buildQuery(RequestMetaData metaData) {
        Map<String, String> queryParams = metaData.getQueryParams();

        if (isEmpty(queryParams))
            return null;

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, String> queryParam : queryParams.entrySet()) {
            if (isNotEmpty(queryParam.getKey()) && isNotEmpty(queryParam.getValue())) {
                sb.append(queryParam.getKey()).append("=").append(queryParam.getValue());
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
                if (isNotEmpty(pathParam.getKey()) && isNotEmpty(pathParam.getValue())) {
                    path = path.replace("{" + pathParam.getKey() + "}", pathParam.getValue());
                }
            }
        }

        if (path.charAt(0) != '/') {
            path = '/' + path;
        }

        return path;
    }
}
