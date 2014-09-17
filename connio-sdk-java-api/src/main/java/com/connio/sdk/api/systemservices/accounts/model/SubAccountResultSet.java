package com.connio.sdk.api.systemservices.accounts.model;

import java.io.Serializable;
import java.util.Set;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 11.09.2014
 */
public class SubAccountResultSet implements Serializable {

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
    private String bookmark;

    /**
     * TODO: javadoc
     */
    private Set<SubAccountDetails> resultSet;

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

    public String getBookmark() {
        return bookmark;
    }

    public void setBookmark(String bookmark) {
        this.bookmark = bookmark;
    }

    public Set<SubAccountDetails> getResultSet() {
        return resultSet;
    }

    public void setResultSet(Set<SubAccountDetails> resultSet) {
        this.resultSet = resultSet;
    }
}
