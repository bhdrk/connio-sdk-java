package com.connio.sdk.http.utils;

import com.connio.sdk.api.model.ConnioRequest;
import com.connio.sdk.api.model.RequestMetaData;
import org.apache.http.HttpEntity;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 17.09.2014
 */
public interface HttpEntityConverter {

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    HttpEntity convert(ConnioRequest request, RequestMetaData metaData);
}
