package com.connio.sdk.api.systemservices.accounts.model;

import java.util.Locale;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 11.09.2014
 */
public enum PlanType {
    TRIAL, MARKER, SYSINT, ENTERPRISE;

    @Override
    public String toString() {
        return name().toLowerCase(Locale.ENGLISH);
    }
}