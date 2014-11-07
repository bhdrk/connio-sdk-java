package com.connio.sdk.api.systemservices.datachannels.model.measurement;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public enum EnergyFitnessMeasurementUnit implements MeasurementUnit {
    CAL("cal"), KCAL("kcal"), J("j");

    private final String symbol;

    EnergyFitnessMeasurementUnit(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

}
