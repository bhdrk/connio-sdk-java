package com.connio.sdk.api.systemservices.datachannels.model;

import java.util.Locale;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 24.09.2014
 */
public enum AlarmType {
    PASSIVE;

    @Override
    public String toString() {
        return name().toLowerCase(Locale.ENGLISH);
    }
}
