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
public class SystemPropertyCredentialsProvider implements ConnioCredentialsProvider {
    @Override
    public ConnioCredentials getCredentials() {
        String accessKey = System.getProperty("connio.auth.accessKey");
        String secretKey = System.getProperty("connio.auth.secretKey");

        if (TypeUtils.isNotEmpty(accessKey) && TypeUtils.isNotEmpty(secretKey)) {
            return new ConnioBasicCredentials(accessKey, secretKey);
        }

        return null;
    }
}
