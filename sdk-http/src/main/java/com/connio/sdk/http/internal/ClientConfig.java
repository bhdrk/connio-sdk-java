package com.connio.sdk.http.internal;

import com.connio.sdk.api.exception.ConnioClientException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import static com.connio.sdk.api.utils.TypeUtils.isEmpty;

/**
 * Client configuration
 */
public class ClientConfig {

    private URI serviceURI;

    private String proxyHost = null;

    private int proxyPort = -1;

    private String proxyType = null;

    private String proxyUsername = null;

    private String proxyPassword = null;

    private String proxyDomain = null;

    private String proxyWorkstation = null;

    private int connectionTimeout;

    private int connectionRequestTimeout;

    public ClientConfig(Map<String, String> configMap) {
        if (configMap.containsKey("connio.http.serviceUrl")) {
            try {
                this.serviceURI = new URI(configMap.get("connio.http.serviceUrl"));
            } catch (URISyntaxException e) {
                throw new ConnioClientException("ServiceUrl syntax exception", e);
            }
        } else {
            throw new ConnioClientException("'connio.http.serviceUrl' is required!");
        }

        if (configMap.containsKey("connio.http.connectionTimeout"))
            this.connectionTimeout = toInt(configMap, "connio.http.connectionTimeout", 50000);

        if (configMap.containsKey("connio.http.connectionRequestTimeout"))
            this.connectionRequestTimeout = toInt(configMap, "connio.http.connectionRequestTimeout", 30000);

        if (configMap.containsKey("connio.http.proxyHost"))
            this.proxyHost = configMap.get("connio.http.proxyHost");

        if (configMap.containsKey("connio.http.proxyPort"))
            this.proxyPort = toInt(configMap, "connio.http.proxyPort", -1);

        if (configMap.containsKey("connio.http.proxyType"))
            this.proxyType = configMap.get("connio.http.proxyType");

        if (configMap.containsKey("connio.http.proxyUsername"))
            this.proxyUsername = configMap.get("connio.http.proxyUsername");

        if (configMap.containsKey("connio.http.proxyPassword"))
            this.proxyPassword = configMap.get("connio.http.proxyPassword");

        if (configMap.containsKey("connio.http.proxyDomain"))
            this.proxyDomain = configMap.get("connio.http.proxyDomain");

        if (configMap.containsKey("connio.http.proxyWorkstation"))
            this.proxyWorkstation = configMap.get("connio.http.proxyWorkstation");
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

    public String getProxyHost() {
        return proxyHost;
    }

    public int getProxyPort() {
        return proxyPort;
    }

    public String getProxyType() {
        return proxyType;
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

    public int getConnectionRequestTimeout() {
        return connectionRequestTimeout;
    }

    public URI getServiceURI() {
        return serviceURI;
    }
}