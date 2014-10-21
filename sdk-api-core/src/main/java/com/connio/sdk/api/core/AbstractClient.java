package com.connio.sdk.api.core;

import com.connio.sdk.api.auth.ConnioCredentials;
import com.connio.sdk.api.auth.ConnioCredentialsManager;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.exception.ConnioServiceException;
import com.connio.sdk.api.model.ConnioRequest;
import com.connio.sdk.api.model.ConnioResponse;
import com.connio.sdk.api.utils.Asserts;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 29.09.2014
 */
public abstract class AbstractClient implements ConnioClient {
    private ConnioClientTransformer context;

    private String credentialsProfile;

    protected AbstractClient() {
        this(ConnioCredentials.DEFAULT_PROFILE);
    }

    protected AbstractClient(String credentialsProfile) {
        Asserts.notEmpty(credentialsProfile, "Credentials Profile");

        this.credentialsProfile = credentialsProfile;
        this.context = ConnioClientTransformerProvider.get();
    }

    protected <RT, RS extends ConnioResponse<RT>> RT execute(ConnioRequest<RS> request)
            throws ConnioServiceException, ConnioClientException {
        ConnioCredentials credentials = ConnioCredentialsManager.getCredentials(credentialsProfile);
        RS response = context.execute(request, credentials);
        return response != null ? response.getResult() : null;
    }
}
