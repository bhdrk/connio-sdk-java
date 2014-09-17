package com.connio.sdk.http.internal;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 16.09.2014
 */
public class InternalConfig {

    public static final String USER_AGENT_TEMPLATE = "connio-sdk-{platform}/{version} {os.name}/{os.version} {java.vm.name}/{java.vm.version}/{java.version} {language}({region})";

    public static final String VERSION_INFO_FILE = "com/connio/sdk/version.properties";

    public static final String DEFAULT_CONFIG_FILE = "com/connio/sdk/default.properties";

    public static final String USER_DEFINED_CONFIG_FILE = "com/connio/sdk/default.properties";

}
