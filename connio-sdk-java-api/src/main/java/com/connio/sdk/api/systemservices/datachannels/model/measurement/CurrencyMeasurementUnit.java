package com.connio.sdk.api.systemservices.datachannels.model.measurement;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public enum CurrencyMeasurementUnit implements MeasurementUnit {
    USD("USD"), CAD("CAD"), EUR("EUR"), GBP("GBP");

    private final String symbol;

    CurrencyMeasurementUnit(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }
}
