package com.connio.sdk.api.systemservices.devices.model;

import java.io.Serializable;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 29.09.2014
 */
public class Location implements Serializable {

    private String name;
    private GeoCoordinates geoCoord;

    public Location() {
    }

    public Location(String name, GeoCoordinates geoCoord) {
        this.name = name;
        this.geoCoord = geoCoord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GeoCoordinates getGeoCoord() {
        return geoCoord;
    }

    public void setGeoCoord(GeoCoordinates geoCoord) {
        this.geoCoord = geoCoord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (geoCoord != null ? !geoCoord.equals(location.geoCoord) : location.geoCoord != null) return false;
        if (name != null ? !name.equals(location.name) : location.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (geoCoord != null ? geoCoord.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", geoCoord=" + geoCoord +
                '}';
    }
}
