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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResultSet resultSet1 = (ResultSet) o;

        if (bookmark != null ? !bookmark.equals(resultSet1.bookmark) : resultSet1.bookmark != null) return false;
        if (itemCount != null ? !itemCount.equals(resultSet1.itemCount) : resultSet1.itemCount != null) return false;
        if (limit != null ? !limit.equals(resultSet1.limit) : resultSet1.limit != null) return false;
        if (resultSet != null ? !resultSet.equals(resultSet1.resultSet) : resultSet1.resultSet != null) return false;
        if (skip != null ? !skip.equals(resultSet1.skip) : resultSet1.skip != null) return false;
        if (total != null ? !total.equals(resultSet1.total) : resultSet1.total != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = total != null ? total.hashCode() : 0;
        result = 31 * result + (itemCount != null ? itemCount.hashCode() : 0);
        result = 31 * result + (skip != null ? skip.hashCode() : 0);
        result = 31 * result + (limit != null ? limit.hashCode() : 0);
        result = 31 * result + (resultSet != null ? resultSet.hashCode() : 0);
        result = 31 * result + (bookmark != null ? bookmark.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "total=" + total +
                ", itemCount=" + itemCount +
                ", skip=" + skip +
                ", limit=" + limit +
                ", resultSet=" + resultSet +
                ", bookmark='" + bookmark + '\'' +
                '}';
    }
}
