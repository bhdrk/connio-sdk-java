package com.connio.sdk.api.dataservices.model;

import com.connio.sdk.api.model.Location;
import com.connio.sdk.api.utils.Asserts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: javadoc
 * <p/>
 * Created by bdirik on 16.10.2014.
 */
public class DataFeed implements Serializable {

    private List<DataPoint> datapoints = new ArrayList<DataPoint>();

    private String id_;
    private Location loc_;
    private String srcUri_;
    private List<String> tags_;
    private String chan_;

    public DataFeed() {
    }

    public DataFeed(List<DataPoint> datapoints) {
        this.datapoints = datapoints;
    }

    public DataFeed(DataPoint... datapoints) {
        Asserts.notEmpty(datapoints, "DataPoints");

        for (DataPoint datapoint : datapoints) {
            addDataPoint(datapoint);
        }
    }

    public void addDataPoint(DataPoint dataPoint) {
        Asserts.notNull(dataPoint.getValue(), "Value");
        Asserts.notNull(dataPoint.getTime(), "Time");

        datapoints.add(dataPoint);
    }

    public List<DataPoint> getDatapoints() {
        return datapoints;
    }

    public void setDatapoints(List<DataPoint> datapoints) {
        this.datapoints = datapoints;
    }

    public String getId_() {
        return id_;
    }

    public void setId_(String id_) {
        this.id_ = id_;
    }

    public String getSrcUri_() {
        return srcUri_;
    }

    public void setSrcUri_(String srcUri_) {
        this.srcUri_ = srcUri_;
    }

    public String getChan_() {
        return chan_;
    }

    public void setChan_(String chan_) {
        this.chan_ = chan_;
    }

    public Location getLoc_() {
        return loc_;
    }

    public void setLoc_(Location loc_) {
        this.loc_ = loc_;
    }

    public List<String> getTags_() {
        return tags_;
    }

    public void setTags_(List<String> tags_) {
        this.tags_ = tags_;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataFeed dataFeed = (DataFeed) o;

        if (chan_ != null ? !chan_.equals(dataFeed.chan_) : dataFeed.chan_ != null) return false;
        if (id_ != null ? !id_.equals(dataFeed.id_) : dataFeed.id_ != null) return false;
        if (loc_ != null ? !loc_.equals(dataFeed.loc_) : dataFeed.loc_ != null) return false;
        if (srcUri_ != null ? !srcUri_.equals(dataFeed.srcUri_) : dataFeed.srcUri_ != null) return false;
        if (tags_ != null ? !tags_.equals(dataFeed.tags_) : dataFeed.tags_ != null) return false;
        if (datapoints != null ? !datapoints.equals(dataFeed.datapoints) : dataFeed.datapoints != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = datapoints != null ? datapoints.hashCode() : 0;
        result = 31 * result + (id_ != null ? id_.hashCode() : 0);
        result = 31 * result + (srcUri_ != null ? srcUri_.hashCode() : 0);
        result = 31 * result + (chan_ != null ? chan_.hashCode() : 0);
        result = 31 * result + (loc_ != null ? loc_.hashCode() : 0);
        result = 31 * result + (tags_ != null ? tags_.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DataFeed{" +
                "datapoints=" + datapoints +
                ", id_='" + id_ + '\'' +
                ", srcUri_='" + srcUri_ + '\'' +
                ", chan_='" + chan_ + '\'' +
                ", loc_=" + loc_ +
                ", tags_=" + tags_ +
                '}';
    }
}
