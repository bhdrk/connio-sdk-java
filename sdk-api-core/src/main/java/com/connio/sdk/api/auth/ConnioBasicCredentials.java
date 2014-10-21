package com.connio.sdk.api.auth;


import com.connio.sdk.api.utils.Asserts;

import java.util.Locale;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 17.09.2014
 */
public class ConnioBasicCredentials implements ConnioCredentials {

    private String accessKey;

    private String secretKey;

    private String profile;

    public ConnioBasicCredentials(String profile, String accessKey, String secretKey) {
        Asserts.notEmpty(profile, "Profile");
        Asserts.notEmpty(accessKey, "AccessKey");
        Asserts.notEmpty(secretKey, "SecretKey");

        this.profile = profile.toLowerCase(Locale.ENGLISH);
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

    @Override
    public String getProfile() {
        return profile;
    }
}
