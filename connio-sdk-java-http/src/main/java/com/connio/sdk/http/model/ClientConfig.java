package com.connio.sdk.http.model;

import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.http.factory.ClientConfigFactory;

import java.util.Map;

import static com.connio.sdk.api.utils.TypeUtils.isEmpty;

/**
 * Client configuration
 */
public class ClientConfig {

    private static ClientConfig instance = new ClientConfig(ClientConfigFactory.create());

    public static ClientConfig instance() {
        return instance;
    }

    private String protocol;

    private String host;

    private int port = -1;

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
        this.protocol = defaults.get("connio.http.protocol");
        this.host = defaults.get("connio.http.host");
        this.port = toInt(defaults, "connio.http.port", -1);

        this.connectionTimeout = toInt(defaults, "connio.http.connectionTimeout", 0);
        this.connectionRequestTimeout = toInt(defaults, "connio.http.connectionRequestTimeout", 0);
        this.socketTimeout = toInt(defaults, ("connio.http.socketTimeout"), 0);
        this.maxConnections = toInt(defaults, "connio.http.maxConnections", 0);
        this.useGzip = toBoolean(defaults, "connio.http.useGzip");

        this.proxyHost = defaults.get("connio.http.proxyHost");
        this.proxyPort = toInt(defaults, "connio.http.proxyPort", -1);
        this.proxyProtocol = defaults.get("connio.http.proxyProtocol");
        this.proxyUsername = defaults.get("connio.http.proxyUsername");
        this.proxyPassword = defaults.get("connio.http.proxyPassword");
        this.proxyDomain = defaults.get("connio.http.proxyDomain");
        this.proxyWorkstation = defaults.get("connio.http.proxyWorkstation");
    }

    private Boolean toBoolean(Map<String, String> defaults, String key) {
        return Boolean.valueOf(defaults.get(key));
    }

    private int toInt(Map<String, String> defaults, String key, int defaultValue) {
        String str = defaults.get(key);

        if (isEmpty(str)) return defaultValue;

        try {
            return Integer.valueOf(str);
        } catch (NumberFormatException e) {
            throw new ConnioClientException("Invalid number format for " + key);
        }
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