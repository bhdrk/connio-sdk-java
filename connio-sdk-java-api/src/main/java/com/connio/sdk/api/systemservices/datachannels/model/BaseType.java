package com.connio.sdk.api.systemservices.datachannels.model;

import java.util.Locale;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public enum BaseType {
    NUMERIC, WAYPOINT, BOOLEAN, EVENT, PREDEFLIST, ANY, COUNTER;

    @Override
    public String toString() {
        return name().toLowerCase(Locale.ENGLISH);
    }
}
