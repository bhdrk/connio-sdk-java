package com.connio.sdk.api.core;

import com.connio.sdk.api.utils.TypeUtils;
import com.connio.sdk.http.HttpClientTransformer;
import com.connio.sdk.http.internal.ClientConfig;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import com.squareup.okhttp.mockwebserver.RecordedRequest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbstractClientMockServerTestCase {

    private MockWebServer mockServer;

    @BeforeClass
    public void startMockServer() throws Exception {
        mockServer = new MockWebServer();
        mockServer.play();
    }

    @AfterClass
    public void stopMockServer() throws Exception {
        mockServer.shutdown();
    }

    public HttpClientTransformer mockTransformer() {
        Map<String, String> configMap = new HashMap<String, String>();
        configMap.put("connio.http.serviceUrl", mockServer.getUrl("").toString());
        ClientConfig clientConfig = new ClientConfig(configMap);
        return new HttpClientTransformer(clientConfig); // create new transformer with mock server url
    }

    public void pushResponse(String body) {
        final Response response = new Response.Builder()
                .responseCode(200)
                .body(body, "application/json")
                .build();

        pushResponse(response);
    }

    public void pushResponse(Response response) {
        MockResponse mockResponse = new MockResponse()
                .setResponseCode(response.responseCode)
                .setBody(response.body);

        for (String header : response.headers) {
            mockResponse.addHeader(header);
        }

        mockServer.enqueue(mockResponse);
    }

    public Request popRequest() throws Exception {
        RecordedRequest recordedRequest = mockServer.takeRequest();
        return new Request(
                recordedRequest.getMethod(),
                recordedRequest.getPath(),
                getHeaders(recordedRequest),
                recordedRequest.getUtf8Body()
        );
    }

    private Map<String, String> getHeaders(RecordedRequest request) {
        HashMap<String, String> headers = new HashMap<String, String>();
        List<String> rawHeaders = request.getHeaders();

        if (TypeUtils.isNotEmpty(rawHeaders)) {
            for (String rawHeader : rawHeaders) {
                int i = rawHeader.indexOf(':');
                if (i != -1) {
                    String name = rawHeader.substring(0, i);
                    String value = rawHeader.substring(i);
                    headers.put(name, value);
                }
            }
        }

        return headers;
    }

    public static class Request {
        private String path;
        private String method;
        private Map<String, String> headers;
        private String body;

        public Request(String method, String path, Map<String, String> headers, String body) {
            this.method = method;
            this.path = path;
            this.headers = headers;
            this.body = body;
        }

        public String getPath() {
            return path;
        }

        public String getMethod() {
            return method;
        }

        public Map<String, String> getHeaders() {
            return headers;
        }

        public String getBody() {
            return body;
        }
    }

    public static class Response {
        private int responseCode;
        private List<String> headers;
        private String body;

        public Response(int responseCode, List<String> headers, String body) {
            this.responseCode = responseCode;
            this.headers = headers;
            this.body = body;
        }

        public static class Builder {
            private int responseCode;
            private List<String> headers = new ArrayList<String>();
            private String body;

            public Builder responseCode(int responseCode) {
                this.responseCode = responseCode;
                return this;
            }

            public Builder addHeader(String name, String value) {
                headers.add(name + ":" + value);
                return this;
            }

            public Builder body(String body, String contentType) {
                this.body = body;
                addHeader("Content-Type", contentType);
                return this;
            }

            public Response build() {
                return new Response(responseCode, headers, body);
            }
        }
    }
}