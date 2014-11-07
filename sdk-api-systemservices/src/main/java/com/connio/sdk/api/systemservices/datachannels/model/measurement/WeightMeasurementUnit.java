package com.connio.sdk.api.systemservices.datachannels.model.measurement;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public enum WeightMeasurementUnit implements MeasurementUnit {
    GR("gr"), KG("kg"), LB("lb"), OZ("oz");

    private final String symbol;

    WeightMeasurementUnit(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

}
