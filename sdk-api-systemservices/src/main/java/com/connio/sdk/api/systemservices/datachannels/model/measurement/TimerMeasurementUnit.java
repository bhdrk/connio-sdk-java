package com.connio.sdk.api.systemservices.datachannels.model.measurement;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public enum TimerMeasurementUnit implements MeasurementUnit {
    MILLIS("millis"), SEC("sec"), MIN("min"), HOUR("hour");

    private final String symbol;

    TimerMeasurementUnit(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }
}
