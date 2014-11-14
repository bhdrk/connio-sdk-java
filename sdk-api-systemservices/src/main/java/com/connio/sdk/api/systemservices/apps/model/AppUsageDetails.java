package com.connio.sdk.api.systemservices.apps.model;

import java.io.Serializable;
import java.util.Map;

/**
 * TODO: javadoc
 * <p/>
 * Created by bdirik on 13.11.2014.
 */
public class AppUsageDetails implements Serializable {

    private Long totalDps;
    private Long totalApiRequests;
    private Map<String, Long> monthlyApiRequests;
    private Long todayDps;
    private Long todayApiRequests;
    private Long storageCapacityInDp;

    public AppUsageDetails() {
    }

    public Long getTotalDps() {
        return totalDps;
    }

    public void setTotalDps(Long totalDps) {
        this.totalDps = totalDps;
    }

    public Long getTotalApiRequests() {
        return totalApiRequests;
    }

    public void setTotalApiRequests(Long totalApiRequests) {
        this.totalApiRequests = totalApiRequests;
    }

    public Map<String, Long> getMonthlyApiRequests() {
        return monthlyApiRequests;
    }

    public void setMonthlyApiRequests(Map<String, Long> monthlyApiRequests) {
        this.monthlyApiRequests = monthlyApiRequests;
    }

    public Long getTodayDps() {
        return todayDps;
    }

    public void setTodayDps(Long todayDps) {
        this.todayDps = todayDps;
    }

    public Long getTodayApiRequests() {
        return todayApiRequests;
    }

    public void setTodayApiRequests(Long todayApiRequests) {
        this.todayApiRequests = todayApiRequests;
    }

    public Long getStorageCapacityInDp() {
        return storageCapacityInDp;
    }

    public void setStorageCapacityInDp(Long storageCapacityInDp) {
        this.storageCapacityInDp = storageCapacityInDp;
    }
}
