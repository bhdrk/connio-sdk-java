package com.connio.sdk.http.internal;

import com.connio.sdk.api.exception.ConnioClientException;

import java.util.Map;

import static com.connio.sdk.api.utils.TypeUtils.isEmpty;

/**
 * Client configuration
 */
public class ClientConfig {

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

    private int connectionTimeout;

    private int connectionRequestTimeout;

    public ClientConfig() {
    }

    public ClientConfig(Map<String, String> defaults) {
        update(defaults);
    }

    public void update(Map<String, String> map) {
        if (map.containsKey("connio.http.protocol"))
            this.protocol = map.get("connio.http.protocol");

        if (map.containsKey("connio.http.host"))
            this.host = map.get("connio.http.host");

        if (map.containsKey("connio.http.port"))
            this.port = toInt(map, "connio.http.port", -1);

        if (map.containsKey("connio.http.connectionTimeout"))
            this.connectionTimeout = toInt(map, "connio.http.connectionTimeout", 0);

        if (map.containsKey("connio.http.connectionRequestTimeout"))
            this.connectionRequestTimeout = toInt(map, "connio.http.connectionRequestTimeout", 0);

        if (map.containsKey("connio.http.proxyHost"))
            this.proxyHost = map.get("connio.http.proxyHost");

        if (map.containsKey("connio.http.proxyPort"))
            this.proxyPort = toInt(map, "connio.http.proxyPort", -1);

        if (map.containsKey("connio.http.proxyProtocol"))
            this.proxyProtocol = map.get("connio.http.proxyProtocol");

        if (map.containsKey("connio.http.proxyUsername"))
            this.proxyUsername = map.get("connio.http.proxyUsername");

        if (map.containsKey("connio.http.proxyPassword"))
            this.proxyPassword = map.get("connio.http.proxyPassword");

        if (map.containsKey("connio.http.proxyDomain"))
            this.proxyDomain = map.get("connio.http.proxyDomain");

        if (map.containsKey("connio.http.proxyWorkstation"))
            this.proxyWorkstation = map.get("connio.http.proxyWorkstation");
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

    public int getConnectionTimeout() {
        return connectionTimeout;
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