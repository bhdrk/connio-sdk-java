package com.connio.sdk.api.systemservices.datachannels.model.measurement;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public enum LengthDistanceMeasurementUnit implements MeasurementUnit {
    MM("mm"), DM("dm"), CM("cm"), M("m"), KM("km"), IN("in"), FT("ft"), YD("yd"), MI("mi");

    private final String symbol;

    LengthDistanceMeasurementUnit(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

}
