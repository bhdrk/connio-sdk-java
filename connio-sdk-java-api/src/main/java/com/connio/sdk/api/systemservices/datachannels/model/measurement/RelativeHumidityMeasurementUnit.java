package com.connio.sdk.api.systemservices.datachannels.model.measurement;

import java.util.Locale;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public enum RelativeHumidityMeasurementUnit implements MeasurementUnit {
    PERCENTAGE("%");

    private final String symbol;

    RelativeHumidityMeasurementUnit(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return name().toLowerCase(Locale.ENGLISH);
    }
}
