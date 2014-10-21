package com.connio.sdk.api.dataservices.model;

import java.io.Serializable;

/**
 * TODO: javadoc
 * <p/>
 * Created by bdirik on 20.10.2014.
 */
public class DataQuery implements Serializable {

    private Integer skip;

    private Integer limit;

    private String bookmark;

    private String sort;

    private String query;

    public DataQuery() {
    }

    public DataQuery(String query) {
        this.query = query;
    }

    public DataQuery(String query, Integer skip, Integer limit, String bookmark, String sort) {
        this.skip = skip;
        this.limit = limit;
        this.bookmark = bookmark;
        this.sort = sort;
        this.query = query;
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

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataQuery dataQuery = (DataQuery) o;

        if (bookmark != null ? !bookmark.equals(dataQuery.bookmark) : dataQuery.bookmark != null) return false;
        if (limit != null ? !limit.equals(dataQuery.limit) : dataQuery.limit != null) return false;
        if (query != null ? !query.equals(dataQuery.query) : dataQuery.query != null) return false;
        if (skip != null ? !skip.equals(dataQuery.skip) : dataQuery.skip != null) return false;
        if (sort != null ? !sort.equals(dataQuery.sort) : dataQuery.sort != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = skip != null ? skip.hashCode() : 0;
        result = 31 * result + (limit != null ? limit.hashCode() : 0);
        result = 31 * result + (bookmark != null ? bookmark.hashCode() : 0);
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        result = 31 * result + (query != null ? query.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DataQuery{" +
                "skip=" + skip +
                ", limit=" + limit +
                ", bookmark='" + bookmark + '\'' +
                ", sort='" + sort + '\'' +
                ", query='" + query + '\'' +
                '}';
    }
}
