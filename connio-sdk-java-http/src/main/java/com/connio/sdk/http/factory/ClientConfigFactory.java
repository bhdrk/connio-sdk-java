package com.connio.sdk.http.factory;

import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.http.model.InternalConfig;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static com.connio.sdk.api.utils.TypeUtils.isNotEmpty;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 15.09.2014
 */
public class ClientConfigFactory {

    private static ClientConfigFactory factory = new ClientConfigFactory();

    private ClientConfigFactory() {
    }

    public static Map<String, String> create() {
        return factory.doCreate();
    }

    private Map<String, String> doCreate() {
        Map<String, String> configMap = getDefaultConfigs();

        overrideFromUserDefinedConfigs(configMap);
        overrideFromSystemProperties(configMap);
        overrideFromEnvProperties(configMap);

        return configMap;
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
        Map<String, String> map = new HashMap<String, String>();
        try {
            URL resource = Thread.currentThread().getContextClassLoader().getResource(InternalConfig.DEFAULT_CONFIG_FILE);
            loadResource(map, resource);
        } catch (Exception e) {
            throw new ConnioClientException("Cannot load " + InternalConfig.DEFAULT_CONFIG_FILE, e);
        }
        return map;
    }

    private Map<String, String> getUserDefinedConfigs() {
        Map<String, String> map = new HashMap<String, String>();

        try {
            Enumeration<URL> resources = getConfigResources(InternalConfig.USER_DEFINED_CONFIG_FILE);
            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                loadResource(map, resource);
            }
        } catch (Exception e) {
            throw new ConnioClientException("Cannot load " + InternalConfig.USER_DEFINED_CONFIG_FILE, e);
        }

        return map;
    }

    private Enumeration<URL> getConfigResources(String name) throws IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        return loader.getResources(name);
    }

    private void loadResource(Map<String, String> map, URL resource) throws IOException {
        InputStream resourceStream = resource.openStream();
        try {
            populateMap(map, resourceStream);
        } finally {
            if (resourceStream != null) {
                resourceStream.close();
            }
        }
    }

    private void populateMap(Map<String, String> map, InputStream resourceStream) throws IOException {
        Properties properties = new Properties();
        properties.load(resourceStream);
        for (String name : properties.stringPropertyNames()) {
            map.put(name, properties.getProperty(name));
        }
    }
}
