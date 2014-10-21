package com.connio.sdk.api.auth.provider;

import com.connio.sdk.api.auth.ConnioBasicCredentials;
import com.connio.sdk.api.auth.ConnioCredentials;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO: javadoc
 * <p/>
 * Created by bdirik on 21.10.2014.
 */
public abstract class AbstractConnioCredentialsProvider implements ConnioCredentialsProvider {

    private Pattern accessKeyPattern;

    private Pattern secretKeyPattern;

    protected AbstractConnioCredentialsProvider(String authPrefix, String accessKeySuffix, String secretKeySuffix) {
        this.accessKeyPattern = Pattern.compile(authPrefix + "(\\w++)" + accessKeySuffix);
        this.secretKeyPattern = Pattern.compile(authPrefix + "(\\w++)" + secretKeySuffix);
    }

    protected Map<String, ConnioCredentials> getCredentialsMap(Map<String, String> valueMap) {
        Map<String, ConnioCredentials> credentialsMap = new HashMap<String, ConnioCredentials>();

        Map<String, String> accessKeyMap = getAccessKeyMap(valueMap);

        for (Map.Entry<String, String> accessEntry : accessKeyMap.entrySet()) {
            String accessKeyProfile = accessEntry.getKey();
            String accessKey = accessEntry.getValue();

            for (Map.Entry<String, String> entry : valueMap.entrySet()) {
                String rawSecretKeyProfile = entry.getKey();
                String secretKey = entry.getValue();

                Matcher matcher = secretKeyPattern.matcher(rawSecretKeyProfile);
                if (matcher.matches()) {
                    String secretKeyProfile = matcher.group(1);

                    if (accessKeyProfile.equalsIgnoreCase(secretKeyProfile)) {
                        ConnioCredentials credentials = new ConnioBasicCredentials(accessKeyProfile, accessKey, secretKey);
                        credentialsMap.put(accessKeyProfile.toLowerCase(Locale.ENGLISH), credentials);
                    }
                }
            }
        }

        return credentialsMap;
    }

    private Map<String, String> getAccessKeyMap(Map<String, String> valueMap) {
        Map<String, String> accessKeyMap = new HashMap<String, String>();

        for (Map.Entry<String, String> entry : valueMap.entrySet()) {
            String rawAccessKeyProfile = entry.getKey();
            String accessKey = entry.getValue();

            Matcher matcher = accessKeyPattern.matcher(rawAccessKeyProfile);
            if (matcher.matches()) {
                String accessKeyProfile = matcher.group(1);
                accessKeyMap.put(accessKeyProfile, accessKey);
            }
        }

        return accessKeyMap;
    }

    protected Map<String, String> toMap(Properties properties) {
        Map<String, String> map = new HashMap<String, String>();

        for (String name : properties.stringPropertyNames()) {
            map.put(name, properties.getProperty(name));
        }

        return map;
    }
}
