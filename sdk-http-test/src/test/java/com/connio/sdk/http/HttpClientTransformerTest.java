package com.connio.sdk.http;

import com.connio.sdk.api.auth.ConnioBasicCredentials;
import com.connio.sdk.api.auth.ConnioCredentials;
import com.connio.sdk.api.systemservices.accounts.model.AccountDetails;
import com.connio.sdk.api.systemservices.accounts.model.GetMyAccountDetailsRequest;
import com.connio.sdk.api.systemservices.accounts.model.GetMyAccountDetailsResponse;
import com.connio.sdk.http.internal.ClientConfig;
import com.connio.sdk.http.internal.ClientFactory;
import com.connio.sdk.http.internal.InternalContext;
import com.connio.sdk.http.json.JSON;
import com.squareup.okhttp.*;
import okio.BufferedSource;
import okio.Okio;
import org.fest.assertions.api.Assertions;
import org.mockito.Matchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareEverythingForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.connio.sdk.api.systemservices.TestUtils.resource;
import static org.powermock.api.mockito.PowerMockito.*;

@PrepareEverythingForTest
public class HttpClientTransformerTest extends PowerMockTestCase {

    private HttpClientTransformer transformer;

    private OkHttpClient mockClient;

    @BeforeMethod
    public void beforeMethod() throws Exception {
        mockStatic(InternalContext.class);

        mockClient = PowerMockito.mock(OkHttpClient.class);

        ClientFactory mockClientFactory = mock(ClientFactory.class);

        when(InternalContext.clientFactory()).thenReturn(mockClientFactory);
        when(mockClientFactory.create(Matchers.any(ClientConfig.class))).thenReturn(mockClient);

        transformer = new HttpClientTransformer();
    }

    @Test
    public void testDoExecuteForSuccessfulResponse() throws Exception {
        ConnioCredentials credentials = new ConnioBasicCredentials("DEFAULT", "D0123456789123456789123456789123", "8ec9e53488dc4e7894f89f32d0595c36");

        GetMyAccountDetailsRequest request = new GetMyAccountDetailsRequest();

        Call mockCall = mock(Call.class);
        Request mockRequest = mock(Request.class);
        Response mockResponse = mock(Response.class);

        String json = resource("json/accounts/me.json");
        AccountDetails expected = JSON.fromString(json, AccountDetails.class);

        when(mockClient.newCall(mockRequest)).thenReturn(mockCall);
        when(mockCall.execute()).thenReturn(mockResponse);
        when(mockResponse.isSuccessful()).thenReturn(true);
        when(mockResponse.body()).thenReturn(new JSONResponseBody(json));

        GetMyAccountDetailsResponse response = transformer.doExecute(request, credentials);

        AccountDetails result = response.getResult();

        Assertions.assertThat(result).isEqualTo(expected);
    }

    public static class JSONResponseBody extends ResponseBody {

        private MediaType mediaType;

        private BufferedSource source;

        private long length;

        public JSONResponseBody(String json) {
            byte[] bytes = json.getBytes(StandardCharsets.UTF_8);
            InputStream in = new ByteArrayInputStream(bytes);

            this.mediaType = MediaType.parse("application/json");
            this.length = bytes.length;
            this.source = Okio.buffer(Okio.source(in));
        }

        @Override
        public MediaType contentType() {
            return mediaType;
        }

        @Override
        public long contentLength() {
            return length;
        }

        @Override
        public BufferedSource source() {
            return source;
        }
    }
}