package com.connio.sdk.api.systemservices.datachannels.model.measurement;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public enum ElectricityMeasurementUnit implements MeasurementUnit {
    KWH("KWh"), W("W"), V("V"), A("A");

    private final String symbol;

    ElectricityMeasurementUnit(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }
}
