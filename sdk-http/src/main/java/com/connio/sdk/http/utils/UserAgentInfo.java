package com.connio.sdk.http.utils;

import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.utils.TypeUtils;
import com.connio.sdk.http.internal.Constants;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 16.09.2014
 */
public class UserAgentInfo {

    private String userAgent;
    private String platform;
    private String version;

    public UserAgentInfo() {
        loadVersionInfo();
        buildUserAgent();
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getPlatform() {
        return platform;
    }

    public String getVersion() {
        return version;
    }

    private void buildUserAgent() {
        String userAgentTemplate = Constants.USER_AGENT_TEMPLATE;
        userAgent = userAgentTemplate
                .replace("{platform}", platform)
                .replace("{version}", version)
                .replace("{os.name}", getSystemProperty("os.name"))
                .replace("{os.version}", getSystemProperty("os.version"))
                .replace("{java.vm.name}", getSystemProperty("java.vm.name"))
                .replace("{java.vm.version}", getSystemProperty("java.vm.version"))
                .replace("{java.version}", getSystemProperty("java.version"))
                .replace("{language}", getSystemProperty("user.language"))
                .replace("{region}", getSystemProperty("user.region"));
    }

    private String getSystemProperty(String name) {
        String property = System.getProperty(name);
        return property != null ? property : "";
    }

    private void loadVersionInfo() {
        InputStream resource = null;
        try {
            resource = ClassResourceLoader.getResourceAsStream(Constants.VERSION_INFO_FILE, UserAgentInfo.class);
            if (resource != null) {
                Properties properties = new Properties();
                properties.load(resource);

                version = properties.getProperty("version");
                platform = properties.getProperty("platform");

                if (TypeUtils.isEmpty(version)) {
                    throw new ConnioClientException("'version' not found in version.properties file.");
                }
                if (TypeUtils.isEmpty(platform)) {
                    throw new ConnioClientException("'platform' not found in version.properties file.");
                }
            } else {
                throw new ConnioClientException("version.properties not found.");
            }
        } catch (IOException e) {
            throw new ConnioClientException("An error occurred while loading version.properties file.", e);
        } finally {
            IOUtils.closeSilently(resource);
        }
    }
}
