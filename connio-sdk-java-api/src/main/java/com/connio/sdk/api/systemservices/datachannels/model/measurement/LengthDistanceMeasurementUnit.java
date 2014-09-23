package com.connio.sdk.api.systemservices.datachannels.model.measurement;

import java.util.Locale;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public enum LengthDistanceMeasurementUnit implements MeasurementUnit {
    MM("Mm"), DM("Dm"), CM("Cm"), M("m"), KM("Km"), IN("In"), FT("Ft"), YD("Yd"), MI("Mi");

    private final String symbol;

    LengthDistanceMeasurementUnit(String symbol) {
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
