package com.connio.sdk.api.auth.provider;

import com.connio.sdk.api.auth.ConnioCredentials;
import com.connio.sdk.api.exception.ConnioClientException;

import java.io.*;
import java.util.Map;
import java.util.Properties;

import static com.connio.sdk.api.utils.TypeUtils.isEmpty;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 18.09.2014
 */
public class ProfileCredentialsProvider extends AbstractConnioCredentialsProvider {

    public static final String AUTH_PREFIX = "connio.auth.";
    public static final String ACCESSKEY_SUFFIX = ".accessKey";
    public static final String SECRETKEY_SUFFIX = ".secretKey";

    private static final String CREDENTIALS_FILE_NAME = ".connioauth";

    public ProfileCredentialsProvider() {
        super(AUTH_PREFIX, ACCESSKEY_SUFFIX, SECRETKEY_SUFFIX);
    }

    @Override
    public Map<String, ConnioCredentials> getCredentialsMap() {
        File credentialsFile = getCredentialsFile();
        if (credentialsFile == null) return null;

        FileReader reader = getFileReader(credentialsFile);
        if (reader == null) return null;

        try {
            Properties properties = new Properties();
            properties.load(reader);

            Map<String, ConnioCredentials> credentialsMap = getCredentialsMap(toMap(properties));

            if (isEmpty(credentialsMap)) {
                throw new ConnioClientException("Credentials are missing in " + credentialsFile);
            }

            return credentialsMap;
        } catch (IOException e) {
            throw new ConnioClientException("Cannot load Connio credentials file.", e);
        } finally {
            closeSilently(reader);
        }
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
