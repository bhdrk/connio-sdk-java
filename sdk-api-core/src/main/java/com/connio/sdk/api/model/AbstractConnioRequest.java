package com.connio.sdk.api.model;

import com.connio.sdk.api.utils.Asserts;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public abstract class AbstractConnioRequest<RS extends AbstractConnioResponse> implements ConnioRequest<RS> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        Asserts.notNull(metaData, "Metadata");

        metaData.setVersion("v1");
        metaData.addPath("/v1");
        metaData.setContentType(new ContentType("application/json", "utf-8"));
    }
}
