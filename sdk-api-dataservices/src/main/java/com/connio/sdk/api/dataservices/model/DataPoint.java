package com.connio.sdk.api.dataservices.model;

import com.connio.sdk.api.model.Location;

import java.io.Serializable;
import java.util.List;

/**
 * TODO: javadoc
 *
 * Created by bdirik on 16.10.2014.
 */
public class DataPoint implements Serializable {

    private Long time;
    private Object value;

    private String feedId_;
    private Location loc_;
    private String srcUri_;
    private List<String> tags_;
    private String chan_;

    public DataPoint() {
    }

    public DataPoint(Long time, Object value) {
        this.time = time;
        this.value = value;
    }

    public DataPoint(Long time, Object value, String chan_) {
        this.time = time;
        this.value = value;
        this.chan_ = chan_;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getFeedId_() {
        return feedId_;
    }

    public void setFeedId_(String feedId_) {
        this.feedId_ = feedId_;
    }

    public Location getLoc_() {
        return loc_;
    }

    public void setLoc_(Location loc_) {
        this.loc_ = loc_;
    }

    public String getSrcUri_() {
        return srcUri_;
    }

    public void setSrcUri_(String srcUri_) {
        this.srcUri_ = srcUri_;
    }

    public List<String> getTags_() {
        return tags_;
    }

    public void setTags_(List<String> tags_) {
        this.tags_ = tags_;
    }

    public String getChan_() {
        return chan_;
    }

    public void setChan_(String chan_) {
        this.chan_ = chan_;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataPoint dataPoint = (DataPoint) o;

        if (chan_ != null ? !chan_.equals(dataPoint.chan_) : dataPoint.chan_ != null) return false;
        if (feedId_ != null ? !feedId_.equals(dataPoint.feedId_) : dataPoint.feedId_ != null) return false;
        if (loc_ != null ? !loc_.equals(dataPoint.loc_) : dataPoint.loc_ != null) return false;
        if (srcUri_ != null ? !srcUri_.equals(dataPoint.srcUri_) : dataPoint.srcUri_ != null) return false;
        if (tags_ != null ? !tags_.equals(dataPoint.tags_) : dataPoint.tags_ != null) return false;
        if (time != null ? !time.equals(dataPoint.time) : dataPoint.time != null) return false;
        if (value != null ? !value.equals(dataPoint.value) : dataPoint.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = time != null ? time.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (feedId_ != null ? feedId_.hashCode() : 0);
        result = 31 * result + (loc_ != null ? loc_.hashCode() : 0);
        result = 31 * result + (srcUri_ != null ? srcUri_.hashCode() : 0);
        result = 31 * result + (tags_ != null ? tags_.hashCode() : 0);
        result = 31 * result + (chan_ != null ? chan_.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DataPoint{" +
                "time=" + time +
                ", value='" + value + '\'' +
                ", feedId_='" + feedId_ + '\'' +
                ", loc_=" + loc_ +
                ", srcUri_='" + srcUri_ + '\'' +
                ", tags_=" + tags_ +
                ", chan_='" + chan_ + '\'' +
                '}';
    }
}
