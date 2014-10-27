package com.connio.sdk.http;

import com.connio.sdk.api.auth.ConnioCredentials;
import com.connio.sdk.api.core.AbstractClientTransformer;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.model.ConnioRequest;
import com.connio.sdk.api.model.ConnioResponse;
import com.connio.sdk.http.internal.ClientConfig;
import com.connio.sdk.http.internal.InternalContext;
import com.connio.sdk.http.utils.HttpUtils;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 15.09.2014
 */
public class HttpClientTransformer extends AbstractClientTransformer {

    private static final Logger LOG = LoggerFactory.getLogger(HttpClientTransformer.class);

    private OkHttpClient client;

    private ClientConfig clientConfig;

    public HttpClientTransformer() {
        this.clientConfig = InternalContext.clientConfigFactory().create();
        this.client = InternalContext.clientFactory().create(clientConfig);
    }

    @Override
    protected <RS extends ConnioResponse> RS doExecute(ConnioRequest<RS> connioRequest, ConnioCredentials credentials) {
        if (LOG.isDebugEnabled())
            LOG.debug("Sending new request...");

        Class<RS> responseType = HttpUtils.resolveResponseType(connioRequest);

        try {
            Request request = InternalContext.requestFactory().create(clientConfig, connioRequest, credentials);
            Response response = client.newCall(request).execute();

            if (LOG.isDebugEnabled())
                LOG.debug("Received new response...");

            return InternalContext.responseFactory().create(response, responseType);
        } catch (IOException e) {
            if (LOG.isDebugEnabled())
                LOG.debug("An error occurred while executing http request.", e);

            throw new ConnioClientException("An error occurred while executing http request.", e);
        }
    }
}
