package com.connio.sdk.http.gzip;

import org.apache.http.HttpException;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 16.09.2014
 */
public class GzipRequestInterceptor implements HttpRequestInterceptor {
    @Override
    public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
        if (!request.containsHeader(HttpHeaders.ACCEPT_ENCODING)) {
            request.addHeader(HttpHeaders.ACCEPT_ENCODING, "gzip");
        }
    }
}
