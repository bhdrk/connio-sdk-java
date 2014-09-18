package com.connio.sdk.http.utils;

import com.connio.sdk.api.model.AbstractConnioRequest;
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
    public HttpEntity convert(AbstractConnioRequest request);
}
