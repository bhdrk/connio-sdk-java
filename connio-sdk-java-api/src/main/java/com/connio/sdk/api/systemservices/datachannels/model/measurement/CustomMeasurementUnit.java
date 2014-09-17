package com.connio.sdk.api.systemservices.datachannels.model.measurement;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public enum CustomMeasurementUnit implements MeasurementUnit {
    NUMERIC("Numeric"), BOOLEAN("Boolean"), EVENT("Event"), PREDEFINED("Predefined");

    private String symbol;

    CustomMeasurementUnit(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }
}
