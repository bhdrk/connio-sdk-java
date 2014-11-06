package com.connio.sdk.api.systemservices.apps;

import com.connio.sdk.api.auth.ConnioCredentials;
import com.connio.sdk.api.core.AbstractClientMockServerTestCase;
import com.connio.sdk.api.systemservices.apps.model.App;
import com.connio.sdk.api.systemservices.apps.model.AppDetails;
import com.connio.sdk.http.json.JSON;
import org.fest.assertions.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.connio.sdk.api.systemservices.TestUtils.resource;
import static org.fest.assertions.api.Assertions.assertThat;

/**
 * TODO: javadoc
 * <p/>
 * Created by bdirik on 06.11.2014.
 */
@Test(suiteName = "ClientTests")
public class AppClientTest extends AbstractClientMockServerTestCase {

    private IAppClient client;

    @BeforeClass
    public void beforeClass() throws Exception {
        client = new AppClient(ConnioCredentials.DEFAULT_PROFILE, mockTransformer());
    }

    @Test
    public void testCreateApp() throws Exception {
        final String expectedRequestJson = resource("json/systemservices/apps/createApp/request.json");
        final String mockResponseJson = resource("json/systemservices/apps/createApp/response.json");

        pushResponse(mockResponseJson);

        App app = new App();
        app.setName("TEST-APP-14-11-06-14-57-57-017");
        app.setDisplayName("TEST APP");
        app.setDescription("TEST APP DESC");
        app.setVersion("v1.0");
        app.setAppStorageCapacity(100000L);

        AppDetails result = client.createApp(app);
        AppDetails expectedResult = JSON.fromString(mockResponseJson, AppDetails.class);

        Assertions.assertThat(result).isEqualTo(expectedResult);

        Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("POST");
        assertThat(request.getPath()).isEqualTo("/v1/_apps");
        assertThat(request.getBody()).isEqualTo(expectedRequestJson);
    }

    @Test
    public void testGetSubAccountDetails() throws Exception {
        final String expectedRequestJson = resource("json/systemservices/apps/getSubAccountDetails/request.json");
        final String mockResponseJson = resource("json/systemservices/apps/getSubAccountDetails/response.json");

        pushResponse(mockResponseJson);

        String appName = "TEST-APP-14-11-06-14-57-57-017";

        AppDetails result = client.getAppDetails(appName);
        AppDetails expectedResult = JSON.fromString(mockResponseJson, AppDetails.class);

        Assertions.assertThat(result).isEqualTo(expectedResult);

        Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("POST");
        assertThat(request.getPath()).isEqualTo("/v1/_apps");
        assertThat(request.getBody()).isEqualTo(expectedRequestJson);
    }
}
