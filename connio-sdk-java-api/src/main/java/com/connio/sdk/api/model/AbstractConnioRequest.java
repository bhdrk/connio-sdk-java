package com.connio.sdk.api.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public abstract class AbstractConnioRequest<T> implements ConnioRequest<T> {

    private RequestMetaData metaData;

    @Override
    public RequestMetaData getRequestMetaData() {
        if (metaData == null) {
            metaData = new RequestMetaData();
            loadMetaData(metaData);
        }
        return metaData;
    }

    protected void loadMetaData(RequestMetaData metaData) {
        metaData.setVersion("v1");
        metaData.setContentType("application/json");
    }

    @Override
    public Class<T> getContentType() {
        return null;
    }

    @Override
    public T getContent() {
        return null;
    }
}
