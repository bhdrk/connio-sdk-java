package com.connio.sdk.api.systemservices.apps;

import com.connio.sdk.api.systemservices.apps.model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 22.09.2014
 */
public class AppEndpointClientImplHttpTest {

    private AppEndpointClientImpl client;

    @Before
    public void setUp() throws Exception {
        client = new AppEndpointClientImpl();
    }

    @Test
    public void testCreateApp() throws Exception {
        String appName = "testapp-" + UUID.randomUUID().toString();

        App app = new App();
        app.setName(appName);
        app.setDisplayName("TEST APP");
        app.setDescription("TEST APP DESC");
        app.setAppStorageCapacity(100000L);

        CreateAppRequest request = new CreateAppRequest();
        request.setApp(app);

        CreateAppResponse response = client.createApp(request);

        assertThat(response).isNotNull();
        assertThat(response.getResult()).isNotNull();

        AppDetails result = response.getResult();

        assertThat(result.getName()).isEqualTo(app.getName());
        assertThat(result.getDisplayName()).isEqualTo(app.getDisplayName());
        assertThat(result.getDescription()).isEqualTo(app.getDescription());
        assertThat(result.getAppStorageCapacity()).isEqualTo(app.getAppStorageCapacity());
    }

    @Test
    public void testGetAllAppDetails() throws Exception {
        GetAllAppDetailsRequest request = new GetAllAppDetailsRequest();
        GetAllAppDetailsResponse response = client.getAllAppDetails(request);

        assertThat(response).isNotNull();
        assertThat(response.getResult()).isNotNull();

        //AppResultSet result = response.getResult();
    }
}
