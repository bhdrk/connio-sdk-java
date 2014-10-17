package com.connio.sdk.api.systemservices.datachannels.model.measurement;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public enum MeasurementType {
    WAYPOINT(WaypointMeasurementUnit.values()),

    TIMER(TimerMeasurementUnit.values()),

    ACCELERATION(AccelerationMeasurementUnit.values()),

    CURRENCY(CurrencyMeasurementUnit.values()),

    ELECTRICITY(ElectricityMeasurementUnit.values()),

    ENERGYFITNESS(EnergyFitnessMeasurementUnit.values()),

    WEIGHT(WeightMeasurementUnit.values()),

    LENGTHDISTANCE(LengthDistanceMeasurementUnit.values()),

    RELATIVEHUMIDITY(RelativeHumidityMeasurementUnit.values()),

    LIGHT(LightMeasurementUnit.values()),

    PRESSURE(PressureMeasurementUnit.values()),

    SPEED(SpeedMeasurementUnit.values()),

    SOUNDLEVEL(SoundLevelMeasurementUnit.values()),

    TEMPERATURE(TemperatureMeasurementUnit.values()),

    PERCENTAGE(PercentageMeasurementUnit.values()),

    CUSTOM(CustomMeasurementUnit.values());

    private MeasurementUnit[] measurementUnits;

    MeasurementType(MeasurementUnit... measurementUnits) {
        this.measurementUnits = measurementUnits;
    }

    public MeasurementUnit[] getMeasurementUnits() {
        return measurementUnits;
    }

}
