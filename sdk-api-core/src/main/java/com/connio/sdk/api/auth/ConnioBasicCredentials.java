package com.connio.sdk.api.auth;


/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 17.09.2014
 */
public class ConnioBasicCredentials implements ConnioCredentials {

    private String accessKey;

    private String secretKey;

    public ConnioBasicCredentials(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    @Override
    public String getAccessKey() {
        return accessKey;
    }

    @Override
    public String getSecretKey() {
        return secretKey;
    }
}
