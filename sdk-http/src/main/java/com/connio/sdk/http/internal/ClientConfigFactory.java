package com.connio.sdk.http.internal;

import com.connio.sdk.api.exception.ConnioClientException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static com.connio.sdk.api.utils.TypeUtils.isNotEmpty;
import static com.connio.sdk.http.utils.IOUtils.closeSilently;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 15.09.2014
 */
public class ClientConfigFactory {

    private static final ClientConfigFactory factory = new ClientConfigFactory();

    private ClientConfigFactory() {
    }

    public static ClientConfig create() {
        return factory.doCreate();
    }

    private ClientConfig doCreate() {
        Map<String, String> configMap = getDefaultConfigs();

        overrideFromUserDefinedConfigs(configMap);
        overrideFromSystemProperties(configMap);
        overrideFromEnvProperties(configMap);

        return new ClientConfig(configMap);
    }

    private void overrideFromUserDefinedConfigs(Map<String, String> configMap) {
        Map<String, String> userDefinedConfigs = getUserDefinedConfigs();
        if (isNotEmpty(userDefinedConfigs)) {
            for (Map.Entry<String, String> entry : userDefinedConfigs.entrySet()) {
                addToConfigMap(configMap, entry.getKey(), entry.getValue());
            }
        }
    }

    private void overrideFromEnvProperties(Map<String, String> configMap) {
        Map<String, String> envMap = System.getenv();
        for (Map.Entry<String, String> entity : envMap.entrySet()) {
            addToConfigMap(configMap, entity.getKey(), entity.getValue());
        }
    }

    private void overrideFromSystemProperties(Map<String, String> configMap) {
        Properties systemProperties = System.getProperties();
        for (String name : systemProperties.stringPropertyNames()) {
            addToConfigMap(configMap, name, systemProperties.getProperty(name));
        }
    }

    private void addToConfigMap(Map<String, String> configMap, String key, String value) {
        if (configMap.containsKey(key)) {
            configMap.put(key, value);
        }
    }

    private Map<String, String> getDefaultConfigs() {
        try {
            URL resource = getLoader().getResource(Constants.DEFAULT_CONFIG_FILE);
            return loadResource(resource);
        } catch (Exception e) {
            throw new ConnioClientException("Cannot load " + Constants.DEFAULT_CONFIG_FILE, e);
        }
    }

    private Map<String, String> getUserDefinedConfigs() {
        try {
            String userHome = System.getProperty("user.home");
            if (isNotEmpty(userHome)) {
                File file = new File(userHome, Constants.USER_DEFINED_CONFIG_FILE);
                if (file.exists() && file.canRead()) {
                    return loadResource(file.toURI().toURL());
                }
            }

            Map<String, String> propertiesMap = new HashMap<String, String>();
            Enumeration<URL> resources = getLoader().getResources(Constants.USER_RESOURCE_CONFIG_FILE);
            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                propertiesMap.putAll(loadResource(resource));
            }
            return propertiesMap;
        } catch (Exception e) {
            throw new ConnioClientException("Cannot load " + Constants.USER_DEFINED_CONFIG_FILE, e);
        }
    }

    private ClassLoader getLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    private Map<String, String> loadResource(URL resource) throws IOException {
        InputStream resourceStream = resource.openStream();
        try {
            return populateMap(resourceStream);
        } finally {
            closeSilently(resourceStream);
        }
    }

    private Map<String, String> populateMap(InputStream resourceStream) throws IOException {
        Map<String, String> propertiesMap = new HashMap<String, String>();
        Properties properties = new Properties();
        properties.load(resourceStream);
        for (String name : properties.stringPropertyNames()) {
            propertiesMap.put(name, properties.getProperty(name));
        }
        return propertiesMap;
    }
}
