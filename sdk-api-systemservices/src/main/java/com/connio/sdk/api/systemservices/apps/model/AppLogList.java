package com.connio.sdk.api.systemservices.apps.model;

import java.util.List;

/**
 * TODO: javadoc
 *
 * Created by bdirik on 13.11.2014.
 */
public class AppLogList {

    private List<AppLog> logs;

    public AppLogList() {
    }

    public List<AppLog> getLogs() {
        return logs;
    }

    public void setLogs(List<AppLog> logs) {
        this.logs = logs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppLogList that = (AppLogList) o;

        if (logs != null ? !logs.equals(that.logs) : that.logs != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return logs != null ? logs.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "AppLogList{" +
                "logs=" + logs +
                '}';
    }
}
