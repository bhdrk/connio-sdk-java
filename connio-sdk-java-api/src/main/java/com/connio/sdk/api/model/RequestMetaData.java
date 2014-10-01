package com.connio.sdk.api.model;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public class RequestMetaData {

    /**
     * TODO: javadoc
     */
    private String version;

    /**
     * TODO: javadoc
     */
    private StringBuilder pathBuilder = new StringBuilder();

    /**
     * TODO: javadoc
     */
    private Map<String, String> pathParams = new HashMap<String, String>(3);

    /**
     * TODO: javadoc
     */
    private Map<String, String> queryParams = new HashMap<String, String>(0);

    /**
     * TODO: javadoc
     */
    private Method method;

    /**
     * TODO: javadoc
     */
    private String contentType;

    /**
     * TODO: javadoc
     */
    private Map<String, String> headers;

    /**
     * TODO: javadoc
     */
    private Object requestContent;

    public String getPath() {
        return pathBuilder.toString();
    }

    public void addPath(String path) {
        pathBuilder.append(path);
    }

    public void addPathParam(String name, String value) {
        pathParams.put(name, value);
    }

    public void addQueryParam(String name, String value) {
        queryParams.put(name, value);
    }

    public Map<String, String> getPathParams() {
        return pathParams;
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Object getRequestContent() {
        return requestContent;
    }

    public void setRequestContent(Object requestContent) {
        this.requestContent = requestContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequestMetaData that = (RequestMetaData) o;

        if (contentType != null ? !contentType.equals(that.contentType) : that.contentType != null) return false;
        if (headers != null ? !headers.equals(that.headers) : that.headers != null) return false;
        if (method != that.method) return false;
        if (pathBuilder != null ? !pathBuilder.equals(that.pathBuilder) : that.pathBuilder != null) return false;
        if (pathParams != null ? !pathParams.equals(that.pathParams) : that.pathParams != null) return false;
        if (queryParams != null ? !queryParams.equals(that.queryParams) : that.queryParams != null) return false;
        if (requestContent != null ? !requestContent.equals(that.requestContent) : that.requestContent != null)
            return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = version != null ? version.hashCode() : 0;
        result = 31 * result + (pathBuilder != null ? pathBuilder.hashCode() : 0);
        result = 31 * result + (pathParams != null ? pathParams.hashCode() : 0);
        result = 31 * result + (queryParams != null ? queryParams.hashCode() : 0);
        result = 31 * result + (method != null ? method.hashCode() : 0);
        result = 31 * result + (contentType != null ? contentType.hashCode() : 0);
        result = 31 * result + (headers != null ? headers.hashCode() : 0);
        result = 31 * result + (requestContent != null ? requestContent.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RequestMetaData{" +
                "version='" + version + '\'' +
                ", pathBuilder=" + pathBuilder +
                ", pathParams=" + pathParams +
                ", queryParams=" + queryParams +
                ", method=" + method +
                ", contentType='" + contentType + '\'' +
                ", headers=" + headers +
                ", requestContent=" + requestContent +
                '}';
    }
}
