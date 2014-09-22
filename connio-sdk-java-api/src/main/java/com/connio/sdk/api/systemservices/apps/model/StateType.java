package com.connio.sdk.api.systemservices.apps.model;

import java.util.Locale;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public enum StateType {
    RUNNING, STOPPED;

    @Override
    public String toString() {
        return name().toLowerCase(Locale.ENGLISH);
    }
}
