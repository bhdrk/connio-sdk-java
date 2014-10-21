package com.connio.sdk.api.dataservices.model;

import java.io.Serializable;

/**
 * TODO: javadoc
 * <p/>
 * Created by bdirik on 17.10.2014.
 */
public class DataFeedDetails implements Serializable {

    private Integer accepted;

    private Integer rejected;

    public Integer getAccepted() {
        return accepted;
    }

    public void setAccepted(Integer accepted) {
        this.accepted = accepted;
    }

    public Integer getRejected() {
        return rejected;
    }

    public void setRejected(Integer rejected) {
        this.rejected = rejected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataFeedDetails that = (DataFeedDetails) o;

        if (accepted != null ? !accepted.equals(that.accepted) : that.accepted != null) return false;
        if (rejected != null ? !rejected.equals(that.rejected) : that.rejected != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = accepted != null ? accepted.hashCode() : 0;
        result = 31 * result + (rejected != null ? rejected.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DataFeedDetails{" +
                "accepted=" + accepted +
                ", rejected=" + rejected +
                '}';
    }
}
