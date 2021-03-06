package com.connio.sdk.api.core;

import com.connio.sdk.api.auth.ConnioCredentials;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.model.ConnioRequest;
import com.connio.sdk.api.model.ConnioResponse;

import java.util.HashMap;
import java.util.Map;

import static com.connio.sdk.api.utils.TypeUtils.isNotEmpty;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 16.09.2014
 */
public abstract class AbstractClientTransformer implements ConnioClientTransformer {

    private Map<String, ConnioRequestHandler> requestHandlers = new HashMap<String, ConnioRequestHandler>();

    private Map<String, ConnioResponseHandler> responseHandlers = new HashMap<String, ConnioResponseHandler>();

    @Override
    public <T extends ConnioResponse> T execute(ConnioRequest<T> request, ConnioCredentials credentials) {
        request = handleRequest(request);
        T response = doExecute(request, credentials);
        handleResponse(response);
        return response;
    }

    protected abstract <RS extends ConnioResponse> RS doExecute(ConnioRequest<RS> request, ConnioCredentials credentials);

    protected <RS extends ConnioResponse> ConnioRequest<RS> handleRequest(ConnioRequest<RS> request) {
        if (isNotEmpty(requestHandlers)) {
            for (ConnioRequestHandler handler : requestHandlers.values()) {
                if (handler.isHandlerFor(request)) {
                    request = handler.handleRequest(request);
                }
            }
        }
        return request;
    }

    protected ConnioResponse handleResponse(ConnioResponse response) {
        if (isNotEmpty(responseHandlers)) {
            for (ConnioResponseHandler handler : responseHandlers.values()) {
                if (handler.isHandlerFor(response)) {
                    response = handler.handleResponse(response);
                }
            }
        }
        return response;
    }

    @Override
    public void addRequestHandler(ConnioRequestHandler handler) {
        String key = handler.getKey();
        if (requestHandlers.containsKey(key)) {
            throw new ConnioClientException("RequestHandler is already added for key: " + key);
        }
        requestHandlers.put(key, handler);
    }

    @Override
    public void addResponseHandler(ConnioResponseHandler handler) {
        String key = handler.getKey();
        if (responseHandlers.containsKey(key)) {
            throw new ConnioClientException("ResponseHandler is already added for key: " + key);
        }
        responseHandlers.put(key, handler);
    }
}
