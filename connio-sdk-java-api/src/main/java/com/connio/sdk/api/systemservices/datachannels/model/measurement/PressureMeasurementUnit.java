package com.connio.sdk.api.systemservices.datachannels.model.measurement;

import java.util.Locale;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public enum PressureMeasurementUnit implements MeasurementUnit {
    BAR("Bar");

    private final String symbol;

    PressureMeasurementUnit(String symbol) {
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
