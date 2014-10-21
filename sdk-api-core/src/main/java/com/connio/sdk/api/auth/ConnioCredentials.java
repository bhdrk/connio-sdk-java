package com.connio.sdk.api.auth;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 17.09.2014
 */
public interface ConnioCredentials {

    public static final String DEFAULT_PROFILE = "DEFAULT";

    /**
     * TODO: javadoc
     *
     * @return
     */
    public String getAccessKey();

    /**
     * TODO: javadoc
     *
     * @return
     */
    public String getSecretKey();

    /**
     * TODO: javadoc
     *
     * @return
     */
    public String getProfile();
}
