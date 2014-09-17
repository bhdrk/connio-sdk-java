package com.connio.sdk.http.model;

import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.http.factory.ClientConfigFactory;

import java.util.Map;

/**
 * Client configuration
 */
public class ClientConfig {

    private static ClientConfig instance = ClientConfigFactory.create();

    public static ClientConfig instance() {
        return instance;
    }

    private String protocol;

    private String host;

    private int port = -1;

    private int maxErrorRetry = -1;

    private String proxyHost = null;

    private int proxyPort = -1;

    private String proxyProtocol = null;

    private String proxyUsername = null;

    private String proxyPassword = null;

    private String proxyDomain = null;

    private String proxyWorkstation = null;

    private int maxConnections;

    private int socketTimeout;

    private int connectionTimeout;

    private int connectionRequestTimeout;

    private boolean useGzip;

    ClientConfig(Map<String, String> defaults) {
        this.protocol = Protocol.fromValue(defaults.get("connio.http.protocol")).name();
        this.host = defaults.get("connio.http.host");
        this.port = toInt(defaults, "connio.http.port");

        this.connectionTimeout = toInt(defaults, "connio.http.connectionTimeout");
        this.connectionRequestTimeout = toInt(defaults, "connio.http.connectionRequestTimeout");
        this.socketTimeout = toInt(defaults, ("connio.http.socketTimeout"));
        this.maxConnections = toInt(defaults, "connio.http.maxConnections");
        this.maxErrorRetry = toInt(defaults, "connio.http.maxErrorRetry");
        this.useGzip = toBoolean(defaults, "connio.http.useGzip");

        this.proxyHost = defaults.get("connio.http.proxyHost");
        this.proxyPort = toInt(defaults, "connio.http.proxyPort");
        this.proxyProtocol = Protocol.fromValue(defaults.get("connio.http.proxyProtocol")).name();
        this.proxyUsername = defaults.get("connio.http.proxyUsername");
        this.proxyPassword = defaults.get("connio.http.proxyPassword");
        this.proxyDomain = defaults.get("connio.http.proxyDomain");
        this.proxyWorkstation = defaults.get("connio.http.proxyWorkstation");
    }

    private Boolean toBoolean(Map<String, String> defaults, String key) {
        return Boolean.valueOf(defaults.get(key));
    }

    private int toInt(Map<String, String> defaults, String key) {
        String str = defaults.get(key);
        try {
            return Integer.valueOf(str);
        } catch (NumberFormatException e) {
            throw new ConnioClientException("Invalid number format for " + key);
        }
    }

    public int getMaxErrorRetry() {
        return maxErrorRetry;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public int getProxyPort() {
        return proxyPort;
    }

    public String getProxyProtocol() {
        return proxyProtocol;
    }

    public String getProxyUsername() {
        return proxyUsername;
    }

    public String getProxyPassword() {
        return proxyPassword;
    }

    public String getProxyDomain() {
        return proxyDomain;
    }

    public String getProxyWorkstation() {
        return proxyWorkstation;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public boolean isUseGzip() {
        return useGzip;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public int getConnectionRequestTimeout() {
        return connectionRequestTimeout;
    }
}