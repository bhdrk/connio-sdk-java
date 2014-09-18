package com.connio.sdk.api.core;

import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.model.AbstractConnioRequest;
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
public abstract class AbstractEndpointClientContext implements ConnioEndpointClientContext {

    private Map<String, ConnioRequestHandler> requestHandlers = new HashMap<String, ConnioRequestHandler>();

    private Map<String, ConnioResponseHandler> responseHandlers = new HashMap<String, ConnioResponseHandler>();

    @Override
    public <T extends ConnioResponse> T execute(AbstractConnioRequest request, Class<T> responseType) {
        request = handleRequest(request);
        T response = doExecute(request, responseType);
        response = responseType.cast(handleResponse(response));
        return response;
    }

    protected abstract <T extends ConnioResponse> T doExecute(AbstractConnioRequest request, Class<T> responseType);

    protected AbstractConnioRequest handleRequest(AbstractConnioRequest request) {
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
