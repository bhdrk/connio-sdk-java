package com.connio.sdk.http.utils;

import com.connio.sdk.http.internal.Constants;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 16.09.2014
 */
public class UserAgentInfo {

    private String userAgent;

    public UserAgentInfo() {
        buildUserAgent();
    }

    public String getUserAgent() {
        return userAgent;
    }

    private void buildUserAgent() {
        String userAgentTemplate = Constants.USER_AGENT_TEMPLATE;
        userAgent = userAgentTemplate
                .replace("{platform}", "java")
                .replace("{version}", getVersion())
                .replace("{os.name}", getSystemProperty("os.name"))
                .replace("{os.version}", getSystemProperty("os.version"))
                .replace("{java.vm.name}", getSystemProperty("java.vm.name"))
                .replace("{java.vm.version}", getSystemProperty("java.vm.version"))
                .replace("{java.version}", getSystemProperty("java.version"))
                .replace("{language}", getSystemProperty("user.language"))
                .replace("{region}", getSystemProperty("user.region"));
    }

    private String getVersion() {
        // should be filled when manifest is built by maven-jar-plugin
        String v = UserAgentInfo.class.getPackage().getImplementationVersion();
        return v != null ? v : "";
    }

    private String getSystemProperty(String name) {
        String property = System.getProperty(name);
        return property != null ? property : "";
    }
}
