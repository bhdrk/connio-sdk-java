package com.connio.sdk.api.auth.provider;

import com.connio.sdk.api.auth.ConnioBasicCredentials;
import com.connio.sdk.api.auth.ConnioCredentials;
import com.connio.sdk.api.exception.ConnioClientException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static com.connio.sdk.api.utils.TypeUtils.isEmpty;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 18.09.2014
 */
public class ProfileCredentialsProvider implements ConnioCredentialsProvider {
    private static final String CREDENTIALS_FILE_NAME = ".conniocds";

    @Override
    public ConnioCredentials getCredentials() {
        String userHome = System.getProperty("user.home");

        if (isEmpty(userHome)) {
            throw new ConnioClientException("Cannot load Connio credentials file. 'user.home' system property is empty");
        }

        File userHomeDir = new File(userHome);
        File credentialsFile = new File(userHomeDir, CREDENTIALS_FILE_NAME);

        if (credentialsFile.exists() && credentialsFile.canRead()) {
            return null;
        }

        FileReader reader;

        try {
            reader = new FileReader(credentialsFile);
        } catch (FileNotFoundException ignored) {
            return null;
        }

        String accessKey, secretKey;

        try {
            Properties properties = new Properties();
            properties.load(reader);

            accessKey = properties.getProperty("connio.accessKey");
            secretKey = properties.getProperty("connio.secretKey");

            if (isEmpty(accessKey) || isEmpty(secretKey)) {
                throw new ConnioClientException("Credentials are missing!");
            }
        } catch (IOException e) {
            throw new ConnioClientException("Cannot load Connio credentials file.", e);
        }

        return new ConnioBasicCredentials(accessKey, secretKey);
    }

}
