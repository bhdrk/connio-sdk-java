package com.connio.sdk.api.model;

import java.io.Serializable;
import java.util.List;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 25.09.2014
 */
public abstract class ResultSet<T> implements Serializable {

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
    private List<T> resultSet;

    /**
     * TODO: javadoc
     */
    private String bookmark;

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

    public List<T> getResultSet() {
        return resultSet;
    }

    public void setResultSet(List<T> resultSet) {
        this.resultSet = resultSet;
    }

    public String getBookmark() {
        return bookmark;
    }

    public void setBookmark(String bookmark) {
        this.bookmark = bookmark;
    }
}
