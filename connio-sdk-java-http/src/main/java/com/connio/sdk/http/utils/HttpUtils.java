package com.connio.sdk.http.utils;

import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.model.ConnioRequest;
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

    /**
     * Build URI for related request.
     *
     * @return
     */
    public static URI buildURI(ClientConfig clientConfig, ConnioRequest request) {

        URIBuilder uriBuilder = new URIBuilder()
                .setScheme(clientConfig.getProtocol())
                .setHost(clientConfig.getHost())
                .setPort(clientConfig.getPort())
                .setPath(buildPath(request));

        Map<String, String> queryParams = request.getRequestMetaData().getQueryParams();

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

    public static String buildPath(ConnioRequest request) {
        RequestMetaData metaData = request.getRequestMetaData();
        String version = metaData.getVersion();
        String endpoint = metaData.getEndpoint();
        String pathTemplate = metaData.getPath();

        StringBuilder pathBuilder = new StringBuilder();

        if (isNotEmpty(version)) {
            pathBuilder.append('/').append(version);
        }

        if (isNotEmpty(endpoint)) {
            pathBuilder.append('/').append(endpoint);
        }

        // append pathTemplate and pathTemplate params
        if (isNotEmpty(pathTemplate)) {
            Map<String, String> pathParams = metaData.getPathParams();
            if (isNotEmpty(pathParams)) {
                for (Map.Entry<String, String> pathParam : pathParams.entrySet()) {
                    if (isNotEmpty(pathParam.getKey()) && isNotEmpty(pathParam.getValue())) {
                        pathTemplate = pathTemplate.replace("{" + pathParam.getKey() + "}", pathParam.getValue());
                    }
                }
            }
            if (pathTemplate.charAt(0) == '/') {
                pathTemplate = pathTemplate.substring(1); // remove first char if it's slash (/)
            }
            pathBuilder.append('/').append(pathTemplate);
        }

        return pathBuilder.toString();
    }

}
