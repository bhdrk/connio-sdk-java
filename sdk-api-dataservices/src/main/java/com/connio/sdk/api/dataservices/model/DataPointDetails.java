package com.connio.sdk.api.dataservices.model;

import com.connio.sdk.api.model.Location;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bdirik on 20.10.2014.
 */
public class DataPointDetails implements Serializable {

    private Long time;
    private Object value;

    private String feedId_;
    private Location loc_;
    private String srcUri_;
    private List<String> tags_;
    private String chan_;
    private String remIp_;
    private Long srvTime_;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
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

    public String getRemIp_() {
        return remIp_;
    }

    public void setRemIp_(String remIp_) {
        this.remIp_ = remIp_;
    }

    public Long getSrvTime_() {
        return srvTime_;
    }

    public void setSrvTime_(Long srvTime_) {
        this.srvTime_ = srvTime_;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataPointDetails that = (DataPointDetails) o;

        if (chan_ != null ? !chan_.equals(that.chan_) : that.chan_ != null) return false;
        if (feedId_ != null ? !feedId_.equals(that.feedId_) : that.feedId_ != null) return false;
        if (loc_ != null ? !loc_.equals(that.loc_) : that.loc_ != null) return false;
        if (remIp_ != null ? !remIp_.equals(that.remIp_) : that.remIp_ != null) return false;
        if (srcUri_ != null ? !srcUri_.equals(that.srcUri_) : that.srcUri_ != null) return false;
        if (srvTime_ != null ? !srvTime_.equals(that.srvTime_) : that.srvTime_ != null) return false;
        if (tags_ != null ? !tags_.equals(that.tags_) : that.tags_ != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

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
        result = 31 * result + (remIp_ != null ? remIp_.hashCode() : 0);
        result = 31 * result + (srvTime_ != null ? srvTime_.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DataPointDetails{" +
                "time=" + time +
                ", value='" + value + '\'' +
                ", feedId_='" + feedId_ + '\'' +
                ", loc_=" + loc_ +
                ", srcUri_='" + srcUri_ + '\'' +
                ", tags_=" + tags_ +
                ", chan_='" + chan_ + '\'' +
                ", remIp_='" + remIp_ + '\'' +
                ", srvTime_=" + srvTime_ +
                '}';
    }
}
