package com.connio.sdk.api.systemservices.devices.model;

import java.io.Serializable;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 29.09.2014
 */
public class GeoCoordinates implements Serializable {

    private Double lat;
    private Double lon;
    private Double radius;

    public GeoCoordinates() {
    }

    public GeoCoordinates(Double lat, Double lon) {
        this(lat, lon, null);
    }

    public GeoCoordinates(Double lat, Double lon, Double radius) {
        this.lat = lat;
        this.lon = lon;
        this.radius = radius;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeoCoordinates that = (GeoCoordinates) o;

        if (lat != null ? !lat.equals(that.lat) : that.lat != null) return false;
        if (lon != null ? !lon.equals(that.lon) : that.lon != null) return false;
        if (radius != null ? !radius.equals(that.radius) : that.radius != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lat != null ? lat.hashCode() : 0;
        result = 31 * result + (lon != null ? lon.hashCode() : 0);
        result = 31 * result + (radius != null ? radius.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GeoCoordinates{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", radius=" + radius +
                '}';
    }
}
