package com.connio.sdk.api.systemservices.apps;

import com.connio.sdk.api.model.Deleted;
import com.connio.sdk.api.systemservices.TestUtils;
import com.connio.sdk.api.systemservices.apps.model.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.connio.sdk.api.systemservices.apps.model.StateType.STOPPED;
import static org.fest.assertions.api.Assertions.assertThat;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 22.09.2014
 */
public class AppEndpointClientImplHttpTest {

    private AppEndpointClientImpl client;

    private App testApp;

    @BeforeClass
    public void beforeClass() throws Exception {
        client = new AppEndpointClientImpl();

        testApp = new App();
        testApp.setName(TestUtils.createNewName("TEST-APP"));
        testApp.setDisplayName("TEST APP");
        testApp.setDescription("TEST APP DESC");
        testApp.setVersion("v1.0");
        testApp.setAppStorageCapacity(100000L);
    }

    @Test(priority = 1)
    public void testCreateApp() throws Exception {
        CreateAppRequest request = new CreateAppRequest(this.testApp);
        CreateAppResponse response = client.createApp(request);

        assertThat(response).isNotNull();
        assertThat(response.getResult()).isNotNull();

        AppDetails result = response.getResult();

        assertThat(result.getName()).isEqualTo(testApp.getName());
        assertThat(result.getDisplayName()).isEqualTo(testApp.getDisplayName());
        assertThat(result.getDescription()).isEqualTo(testApp.getDescription());
        assertThat(result.getAppStorageCapacity()).isEqualTo(testApp.getAppStorageCapacity());
        assertThat(result.getVersion()).isEqualTo(testApp.getVersion());
    }

    @Test(priority = 2)
    public void testGetAppDetails() throws Exception {
        GetAppDetailsRequest request = new GetAppDetailsRequest();
        request.setAppName(this.testApp.getName());

        GetAppDetailsResponse response = client.getAppDetails(request);

        assertThat(response).isNotNull();
        assertThat(response.getResult()).isNotNull();

        AppDetails result = response.getResult();

        assertThat(result.getName()).isEqualTo(testApp.getName());
        assertThat(result.getDisplayName()).isEqualTo(testApp.getDisplayName());
        assertThat(result.getDescription()).isEqualTo(testApp.getDescription());
        assertThat(result.getAppStorageCapacity()).isEqualTo(testApp.getAppStorageCapacity());
        assertThat(result.getVersion()).isEqualTo(testApp.getVersion());
    }

    @Test(priority = 3)
    public void testGetAllAppDetails() throws Exception {
        GetAllAppDetailsRequest request = new GetAllAppDetailsRequest();
        GetAllAppDetailsResponse response = client.getAllAppDetails(request);

        assertThat(response).isNotNull();
        assertThat(response.getResult()).isNotNull();

        AppResultSet result = response.getResult();

        assertThat(result.getTotal()).isGreaterThan(0);
        assertThat(result.getItemCount()).isGreaterThan(0);
        assertThat(result.getResultSet()).isNotEmpty();
    }

    @Test(priority = 4)
    public void testUpdateApp() throws Exception {
        String currentAppName = testApp.getName();
        String newName = TestUtils.createNewName("TEST-APP");

        testApp.setName(newName);
        testApp.setDisplayName("UPDATED TEST APP");
        testApp.setDescription("UPDATED TEST APP DESC");
        testApp.setAppStorageCapacity(500000L);
        testApp.setVersion("v2.0");
        testApp.setState(STOPPED);

        UpdateAppRequest request = new UpdateAppRequest();
        request.setApp(testApp);
        request.setAppName(currentAppName);

        UpdateAppResponse response = client.updateApp(request);

        assertThat(response).isNotNull();
        assertThat(response.getResult()).isNotNull();

        AppDetails result = response.getResult();

        assertThat(result.getName()).isEqualTo(testApp.getName());
        assertThat(result.getDisplayName()).isEqualTo(testApp.getDisplayName());
        assertThat(result.getDescription()).isEqualTo(testApp.getDescription());
        assertThat(result.getAppStorageCapacity()).isEqualTo(testApp.getAppStorageCapacity());
    }

    @Test(priority = 5)
    public void testDeleteApp() throws Exception {
        DeleteAppRequest request = new DeleteAppRequest();
        request.setAppName(testApp.getName());

        DeleteAppResponse response = client.deleteApp(request);

        assertThat(response).isNotNull();
        assertThat(response.getResult()).isNotNull();

        Deleted result = response.getResult();

        assertThat(result.isDeleted()).isTrue();
    }
}
