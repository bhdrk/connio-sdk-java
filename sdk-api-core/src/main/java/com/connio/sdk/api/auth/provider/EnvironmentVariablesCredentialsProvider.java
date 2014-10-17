package com.connio.sdk.api.auth.provider;

import com.connio.sdk.api.auth.ConnioBasicCredentials;
import com.connio.sdk.api.auth.ConnioCredentials;
import com.connio.sdk.api.utils.TypeUtils;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 19.09.2014
 */
public class EnvironmentVariablesCredentialsProvider implements ConnioCredentialsProvider {
    @Override
    public ConnioCredentials getCredentials() {
        String accessKey = System.getenv("CONNIO_AUTH_ACCESSKEY");
        String secretKey = System.getenv("CONNIO_AUTH_SECRETKEY");

        if (TypeUtils.isNotEmpty(accessKey) && TypeUtils.isNotEmpty(secretKey)) {
            return new ConnioBasicCredentials(accessKey, secretKey);
        }

        return null;
    }
}
