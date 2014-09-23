package com.connio.sdk.api.systemservices.apps.model;

import java.io.Serializable;
import java.util.List;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public class AppResultSet implements Serializable {

    /**
     * TODO: javadoc
     */
    private Integer total;

    /**
     * TODO: javadoc
     */
    private Integer itemCount;

    /**
     * TODO: javadoc
     */
    private Integer skip;

    /**
     * TODO: javadoc
     */
    private Integer limit;

    /**
     * TODO: javadoc
     */
    private List<AppDetails> resultSet;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public Integer getSkip() {
        return skip;
    }

    public void setSkip(Integer skip) {
        this.skip = skip;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public List<AppDetails> getResultSet() {
        return resultSet;
    }

    public void setResultSet(List<AppDetails> resultSet) {
        this.resultSet = resultSet;
    }
}
