package com.connio.sdk.http.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 16.09.2014
 */
public class ClassResourceLoader {
    private static final Logger LOG = LoggerFactory.getLogger(ClassResourceLoader.class);

    public static String getResourceAsString(String resourceName, Class<?>... classes) {
        InputStream is = getResourceAsStream(resourceName, classes);
        if (is != null) {
            try {
                return IOUtils.toString(is);
            } catch (IOException e) {
                if (LOG.isDebugEnabled())
                    LOG.debug(e.getMessage(), e);
            }
        }
        return null;
    }

    public static InputStream getResourceAsStream(String resourceName, Class<?>... classes) {
        URL url = getResource(resourceName, classes);
        if (url != null) {
            try {
                return url.openStream();
            } catch (IOException ignored) {
            }
        }
        return null;
    }

    public static URL getResource(String resourceName, Class<?>... classes) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        if (loader != null) {
            URL url = loader.getResource(resourceName);
            if (url != null) {
                return url;
            }
        }

        if (classes != null) {
            for (Class<?> clazz : classes) {
                URL url = clazz.getResource(resourceName);
                if (url != null) {
                    return url;
                }
            }
        }

        URL url = ClassResourceLoader.class.getResource(resourceName);
        if (url != null) {
            return url;
        }

        return null;
    }
}
