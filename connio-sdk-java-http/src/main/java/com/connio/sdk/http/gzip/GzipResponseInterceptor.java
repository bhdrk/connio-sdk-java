package com.connio.sdk.http.gzip;

import org.apache.http.*;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 16.09.2014
 */
public class GzipResponseInterceptor implements HttpResponseInterceptor {
    @Override
    public void process(HttpResponse response, HttpContext context) throws HttpException, IOException {
        HttpEntity entity = response.getEntity();
        if (entity == null) {
            return;
        }

        Header ceheader = entity.getContentEncoding();
        if (ceheader == null) {
            return;
        }

        HeaderElement[] codecs = ceheader.getElements();
        for (HeaderElement codec : codecs) {
            String name = codec.getName();
            if (name.equalsIgnoreCase("gzip")) {
                HttpEntity gzipEntity = new GzipDecompressingEntity(response.getEntity());
                response.setEntity(gzipEntity);
                break;
            }
        }
    }
}
