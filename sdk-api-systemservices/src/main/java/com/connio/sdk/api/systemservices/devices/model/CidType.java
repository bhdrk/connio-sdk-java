package com.connio.sdk.api.systemservices.devices.model;

import java.util.Locale;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 29.09.2014
 */
public enum CidType {
    _ESN, _ID, _IMEI, _MAC, _SN;

    @Override
    public String toString() {
        return name().toLowerCase(Locale.ENGLISH);
    }
}
