package com.connio.sdk.api.systemservices.apps.model;

import java.util.Date;

/**
 * TODO: javadoc
 * <p/>
 * Created by bdirik on 13.11.2014.
 */
public class AppLog {

    private String log;

    private String type;

    private Date date;

    public AppLog() {
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppLog appLog = (AppLog) o;

        if (date != null ? !date.equals(appLog.date) : appLog.date != null) return false;
        if (log != null ? !log.equals(appLog.log) : appLog.log != null) return false;
        if (type != null ? !type.equals(appLog.type) : appLog.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = log != null ? log.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AppLog{" +
                "log='" + log + '\'' +
                ", type='" + type + '\'' +
                ", date=" + date +
                '}';
    }
}
