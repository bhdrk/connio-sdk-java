package com.connio.sdk.api.auth.provider;

import com.connio.sdk.api.auth.ConnioBasicCredentials;
import com.connio.sdk.api.auth.ConnioCredentials;
import com.connio.sdk.api.exception.ConnioClientException;

import java.io.*;
import java.util.Properties;

import static com.connio.sdk.api.utils.TypeUtils.isEmpty;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 18.09.2014
 */
public class ProfileCredentialsProvider implements ConnioCredentialsProvider {
    private static final String CREDENTIALS_FILE_NAME = ".connioauth";

    @Override
    public ConnioCredentials getCredentials() {
        File credentialsFile = getCredentialsFile();
        if (credentialsFile == null) return null;

        FileReader reader = getFileReader(credentialsFile);
        if (reader == null) return null;

        String accessKey, secretKey;

        try {
            Properties properties = new Properties();
            properties.load(reader);

            accessKey = properties.getProperty("connio.auth.accessKey");
            secretKey = properties.getProperty("connio.auth.secretKey");

            if (isEmpty(accessKey) || isEmpty(secretKey)) {
                throw new ConnioClientException("Credentials are missing in " + credentialsFile);
            }
        } catch (IOException e) {
            throw new ConnioClientException("Cannot load Connio credentials file.", e);
        } finally {
            closeSilently(reader);
        }

        return new ConnioBasicCredentials(accessKey, secretKey);
    }

    private FileReader getFileReader(File credentialsFile) {
        FileReader reader;
        try {
            reader = new FileReader(credentialsFile);
        } catch (FileNotFoundException ignored) {
            return null;
        }
        return reader;
    }

    private File getCredentialsFile() {
        String userHome = System.getProperty("user.home");

        if (isEmpty(userHome)) {
            throw new ConnioClientException("Cannot load Connio credentials file. 'user.home' system property is empty");
        }

        File userHomeDir = new File(userHome);
        File credentialsFile = new File(userHomeDir, CREDENTIALS_FILE_NAME);

        if (credentialsFile.exists() && credentialsFile.canRead()) {
            return credentialsFile;
        }
        return null;
    }

    private void closeSilently(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException ignored) {
            }
        }
    }
}
