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

    public ClientConfig() {
    }

    public ClientConfig(Map<String, String> defaults) {
        update(defaults);
    }

    public void update(Map<String, String> map) {
        if (map.containsKey("connio.http.serviceUrl")) {
            try {
                this.serviceURI = new URI(map.get("connio.http.serviceUrl"));
            } catch (URISyntaxException e) {
                throw new ConnioClientException("ServiceUrl syntax exception", e);
            }
        }

        if (map.containsKey("connio.http.connectionTimeout"))
            this.connectionTimeout = toInt(map, "connio.http.connectionTimeout", 0);

        if (map.containsKey("connio.http.connectionRequestTimeout"))
            this.connectionRequestTimeout = toInt(map, "connio.http.connectionRequestTimeout", 0);

        if (map.containsKey("connio.http.proxyHost"))
            this.proxyHost = map.get("connio.http.proxyHost");

        if (map.containsKey("connio.http.proxyPort"))
            this.proxyPort = toInt(map, "connio.http.proxyPort", -1);

        if (map.containsKey("connio.http.proxyType"))
            this.proxyType = map.get("connio.http.proxyType");

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