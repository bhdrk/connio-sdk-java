package com.connio.sdk.api.systemservices.datachannels.model.measurement;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public enum WeightMeasurementUnit implements MeasurementUnit {
    GR("Gr"), KG("Kg"), LB("Lb"), OZ("Oz");

    private final String symbol;

    WeightMeasurementUnit(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }
}
