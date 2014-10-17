package com.connio.sdk.api.systemservices.datachannels.model.measurement;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public enum PercentageMeasurementUnit implements MeasurementUnit {
    PERCENTAGE("%");

    private String symbol;

    PercentageMeasurementUnit(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

}
