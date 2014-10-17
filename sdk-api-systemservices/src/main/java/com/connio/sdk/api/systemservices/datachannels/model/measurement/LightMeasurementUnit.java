package com.connio.sdk.api.systemservices.datachannels.model.measurement;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public enum LightMeasurementUnit implements MeasurementUnit {
    LUMENS("Lumens");

    private final String symbol;

    LightMeasurementUnit(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

}
