package com.connio.sdk.http.internal;

import com.connio.sdk.api.exception.ConnioClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static com.connio.sdk.api.utils.TypeUtils.isEmpty;
import static com.connio.sdk.api.utils.TypeUtils.isNotEmpty;
import static com.connio.sdk.http.utils.IOUtils.closeSilently;
import static com.connio.sdk.http.utils.StringUtils.startsWithIgnoreCase;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 15.09.2014
 */
public class ClientConfigFactory {

    private static final Logger LOG = LoggerFactory.getLogger(ClientConfigFactory.class);

    public ClientConfigFactory() {
    }

    public ClientConfig create() {
        if (LOG.isDebugEnabled())
            LOG.debug("Initializing client config.");

        Map<String, String> configMap = getDefaultConfigs();

        if (LOG.isDebugEnabled()) {
            for (Map.Entry<String, String> config : configMap.entrySet()) {
                LOG.debug("Default: " + config.getKey() + " = " + config.getValue());
            }
        }

        overrideFromUserDefinedConfigs(configMap);
        overrideFromSystemProperties(configMap);
        overrideFromEnvProperties(configMap);

        return new ClientConfig(configMap);
    }

    private void overrideFromUserDefinedConfigs(Map<String, String> configMap) {
        if (LOG.isDebugEnabled())
            LOG.debug("Searching for user defined configurations.");

        Map<String, String> userDefinedConfigs = getUserDefinedConfigs();
        if (isNotEmpty(userDefinedConfigs)) {
            for (Map.Entry<String, String> cnf : userDefinedConfigs.entrySet()) {
                if (isConfigKey(configMap, cnf.getKey())) {
                    if (LOG.isDebugEnabled())
                        LOG.debug("Updating config from user definition: " + cnf.getKey() + " = " + cnf.getValue());

                    updateConfig(configMap, cnf.getKey(), cnf.getValue());
                }
            }
        } else {
            if (LOG.isDebugEnabled())
                LOG.debug("User defined configuration not found.");
        }
    }

    private void overrideFromEnvProperties(Map<String, String> configMap) {
        if (LOG.isDebugEnabled())
            LOG.debug("Searching for environment variable configurations.");

        Map<String, String> envMap = System.getenv();
        boolean found = false;

        for (Map.Entry<String, String> env : envMap.entrySet()) {
            if (isConfigKey(configMap, env.getKey())) {
                if (LOG.isDebugEnabled())
                    LOG.debug("Updating config from environment variable: " + env.getKey() + " = " + env.getValue());

                String dottedKey = env.getKey().replace("_", ".");
                updateConfig(configMap, dottedKey, env.getValue());
                found = true;
            }
        }

        if (!found) {
            if (LOG.isDebugEnabled())
                LOG.debug("Configuration not found in environment variable.");
        }
    }

    private void overrideFromSystemProperties(Map<String, String> configMap) {
        if (LOG.isDebugEnabled())
            LOG.debug("Searching for system property configurations.");

        Properties systemProperties = System.getProperties();
        boolean found = false;

        for (String name : systemProperties.stringPropertyNames()) {
            if (isConfigKey(configMap, name)) {
                String property = systemProperties.getProperty(name);

                if (LOG.isDebugEnabled())
                    LOG.debug("Updating config from system property: " + name + " = " + property);

                updateConfig(configMap, name, property);
                found = true;
            }
        }

        if (!found) {
            if (LOG.isDebugEnabled())
                LOG.debug("Configuration not found in system properties.");
        }
    }

    private void updateConfig(Map<String, String> configMap, String key, String value) {
        for (String mkey : configMap.keySet()) {
            if (mkey.equalsIgnoreCase(key)) {
                configMap.put(mkey, value);
                return;
            }
        }
    }

    private boolean isConfigKey(Map<String, String> configMap, String key) {
        if (startsWithIgnoreCase(key, Constants.CONFIG_KEY_PREFIX)) {
            if (configMap.containsKey(key)) {
                return true;
            } else {
                if (LOG.isWarnEnabled())
                    LOG.warn("'" + key + "' is not a valid configuration!");
            }
        }
        return false;
    }

    private Map<String, String> getDefaultConfigs() {
        if (LOG.isDebugEnabled())
            LOG.debug("Loading default configuration...");

        URL resource = getLoader().getResource(Constants.DEFAULT_CONFIG_FILE);

        return loadResource(resource);
    }

    private Map<String, String> getUserDefinedConfigs() {
        Map<String, String> configMap;

        configMap = getFromFile();

        if (configMap == null)
            configMap = getFromClassPath();

        return configMap;
    }

    private Map<String, String> getFromFile() {
        String userHome = System.getProperty("user.home");

        if (isEmpty(userHome)) {
            if (LOG.isDebugEnabled())
                LOG.debug("user.home not defined!");

            return null;
        }

        File file = new File(userHome, Constants.USER_DEFINED_CONFIG_FILE);

        if (!file.exists()) {
            file = new File(Constants.USER_DEFINED_CONFIG_FILE);
            if (!file.exists()) {
                return null;
            }
        }

        if (LOG.isDebugEnabled())
            LOG.debug("User defined config file found on path " + file.getPath());

        if (!file.canRead()) {
            if (LOG.isDebugEnabled())
                LOG.warn(file.getPath() + " is not accessible!");

            return null;
        }

        try {
            URL resource = file.toURI().toURL();
            return loadResource(resource);
        } catch (MalformedURLException e) {
            throw new ConnioClientException(e);
        }
    }

    private Map<String, String> getFromClassPath() {
        Enumeration<URL> resources;

        try {
            resources = getLoader().getResources(Constants.CLASSPATH_RESOURCE_CONFIG_FILE);
        } catch (IOException e) {
            throw new ConnioClientException("Cannot load user defined configuration on classpath.", e);
        }

        Map<String, String> propertiesMap = new HashMap<String, String>();

        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();

            if (LOG.isDebugEnabled())
                LOG.debug("User defined config file found on classpath: " + resource.toString());

            propertiesMap.putAll(loadResource(resource));
        }

        return propertiesMap;
    }

    private ClassLoader getLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    private Map<String, String> loadResource(URL resource) {
        InputStream resourceStream = null;

        try {
            resourceStream = resource.openStream();

            if (LOG.isDebugEnabled())
                LOG.debug("Loading resource: " + resource.toString());

            return populateMap(resourceStream);
        } catch (IOException e) {
            throw new ConnioClientException("Cannot load resource for " + resource.toString(), e);
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
