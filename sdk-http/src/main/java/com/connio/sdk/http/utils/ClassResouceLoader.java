package com.connio.sdk.http.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 16.09.2014
 */
public class ClassResouceLoader {

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

        return null;
    }
}
