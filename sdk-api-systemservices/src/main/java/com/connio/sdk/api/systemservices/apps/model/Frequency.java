package com.connio.sdk.api.systemservices.apps.model;

import java.io.Serializable;

/**
 * TODO: javadoc
 * <p/>
 * Created by bdirik on 14.11.2014.
 */
public class Frequency implements Serializable {

    private String f;

    private String x;

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Frequency freq = (Frequency) o;

        if (f != null ? !f.equals(freq.f) : freq.f != null) return false;
        if (x != null ? !x.equals(freq.x) : freq.x != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = f != null ? f.hashCode() : 0;
        result = 31 * result + (x != null ? x.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Frequency{" +
                "x='" + x + '\'' +
                ", f='" + f + '\'' +
                '}';
    }
}
