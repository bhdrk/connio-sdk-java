package com.connio.sdk.api.systemservices.datachannels.model;

import java.io.Serializable;
import java.util.List;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public class DataChannelResultSet implements Serializable {

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
    private List<DataChannelDetails> resultSet;

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

    public List<DataChannelDetails> getResultSet() {
        return resultSet;
    }

    public void setResultSet(List<DataChannelDetails> resultSet) {
        this.resultSet = resultSet;
    }
}
