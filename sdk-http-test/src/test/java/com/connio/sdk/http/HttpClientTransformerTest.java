package com.connio.sdk.http;

import com.connio.sdk.api.auth.ConnioBasicCredentials;
import com.connio.sdk.api.auth.ConnioCredentials;
import com.connio.sdk.api.exception.ConnioResourceNotFoundException;
import com.connio.sdk.api.exception.ConnioServiceException;
import com.connio.sdk.api.systemservices.accounts.model.AccountDetails;
import com.connio.sdk.api.systemservices.accounts.model.GetMyAccountDetailsRequest;
import com.connio.sdk.api.systemservices.accounts.model.GetMyAccountDetailsResponse;
import com.connio.sdk.http.json.JSON;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import org.fest.assertions.api.Assertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.connio.sdk.api.systemservices.TestUtils.resource;

public class HttpClientTransformerTest {

    private HttpClientTransformer transformer;

    private MockWebServer mockServer;

    @BeforeMethod
    public void beforeMethod() throws Exception {
        mockServer = new MockWebServer();
        mockServer.play();

        System.setProperty("connio.http.serviceUrl", mockServer.getUrl("").toString());

        transformer = new HttpClientTransformer();
    }

    @AfterMethod
    public void afterMethod() throws Exception {
        mockServer.shutdown();
    }

    @Test
    public void testDoExecuteForSuccessfulResponse() throws Exception {
        String json = resource("json/accounts/me.json");

        MockResponse mockResponse = new MockResponse()
                .setBody(json)
                .addHeader("Content-Type", "application/json");

        mockServer.enqueue(mockResponse);

        ConnioCredentials credentials = new ConnioBasicCredentials("DEFAULT", "D0123456789123456789123456789123", "8ec9e53488dc4e7894f89f32d0595c36");

        GetMyAccountDetailsRequest request = new GetMyAccountDetailsRequest();
        GetMyAccountDetailsResponse response = transformer.doExecute(request, credentials);

        AccountDetails result = response.getResult();
        AccountDetails expected = JSON.fromString(json, AccountDetails.class);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test(expectedExceptions = ConnioServiceException.class)
    public void testDoExecuteFor500() throws Exception {
        MockResponse mockResponse = new MockResponse()
                .setBody("Internal Server Error")
                .setResponseCode(500)
                .addHeader("Content-Type", "text/plain");

        mockServer.enqueue(mockResponse);

        ConnioCredentials credentials = new ConnioBasicCredentials("DEFAULT", "D0123456789123456789123456789123", "8ec9e53488dc4e7894f89f32d0595c36");

        GetMyAccountDetailsRequest request = new GetMyAccountDetailsRequest();

        transformer.doExecute(request, credentials);
    }

    @Test(expectedExceptions = ConnioResourceNotFoundException.class)
    public void testDoExecuteFor404() throws Exception {
        MockResponse mockResponse = new MockResponse()
                .setBody("Not Found")
                .setResponseCode(404)
                .addHeader("Content-Type", "text/plain");

        mockServer.enqueue(mockResponse);

        ConnioCredentials credentials = new ConnioBasicCredentials("DEFAULT", "D0123456789123456789123456789123", "8ec9e53488dc4e7894f89f32d0595c36");

        GetMyAccountDetailsRequest request = new GetMyAccountDetailsRequest();

        transformer.doExecute(request, credentials);
    }
}