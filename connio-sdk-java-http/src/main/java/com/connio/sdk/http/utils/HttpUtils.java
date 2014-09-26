package com.connio.sdk.http.utils;

import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.model.ConnioRequest;
import com.connio.sdk.api.model.ConnioResponse;
import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.http.model.ClientConfig;
import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

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

    /**
     * Build URI for related request.
     *
     * @return
     */
    public static URI buildURI(ClientConfig clientConfig, RequestMetaData metaData) {

        URIBuilder uriBuilder = new URIBuilder()
                .setScheme(clientConfig.getProtocol())
                .setHost(clientConfig.getHost())
                .setPort(clientConfig.getPort())
                .setPath(buildPath(metaData));

        Map<String, String> queryParams = metaData.getQueryParams();

        // append query params
        if (isNotEmpty(queryParams)) {
            for (Map.Entry<String, String> queryParam : queryParams.entrySet()) {
                if (isNotEmpty(queryParam.getKey()) && isNotEmpty(queryParam.getValue())) {
                    uriBuilder.addParameter(queryParam.getKey(), queryParam.getValue());
                }
            }
        }

        try {
            return uriBuilder.build();
        } catch (URISyntaxException e) {
            throw new ConnioClientException("URI Syntax Error", e);
        }
    }

    public static String buildPath(RequestMetaData metaData) {
        String path = metaData.getPath();

        // append path and path params
        if (isNotEmpty(path)) {
            Map<String, String> pathParams = metaData.getPathParams();
            if (isNotEmpty(pathParams)) {
                for (Map.Entry<String, String> pathParam : pathParams.entrySet()) {
                    if (isNotEmpty(pathParam.getKey()) && isNotEmpty(pathParam.getValue())) {
                        path = path.replace("{" + pathParam.getKey() + "}", pathParam.getValue());
                    }
                }
            }
            if (path.charAt(0) != '/') {
                path = '/' + path; // remove first char if it's slash (/)
            }
        }

        return path;
    }

}
