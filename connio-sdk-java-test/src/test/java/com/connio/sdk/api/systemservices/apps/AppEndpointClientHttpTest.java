package com.connio.sdk.api.systemservices.apps;

import com.connio.sdk.api.model.Deleted;
import com.connio.sdk.api.systemservices.TestUtils;
import com.connio.sdk.api.systemservices.apps.model.App;
import com.connio.sdk.api.systemservices.apps.model.AppDetails;
import com.connio.sdk.api.systemservices.apps.model.AppResultSet;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.connio.sdk.api.systemservices.apps.model.AppStateType.STOPPED;
import static org.fest.assertions.api.Assertions.assertThat;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 22.09.2014
 */
@Test(suiteName = "HttpTests", testName = "AppEndpoint")
public class AppEndpointClientHttpTest {

    private AppEndpointClient client;

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
        AppDetails result = client.createApp(testApp);

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(testApp.getName());
        assertThat(result.getDisplayName()).isEqualTo(testApp.getDisplayName());
        assertThat(result.getDescription()).isEqualTo(testApp.getDescription());
        assertThat(result.getAppStorageCapacity()).isEqualTo(testApp.getAppStorageCapacity());
        assertThat(result.getVersion()).isEqualTo(testApp.getVersion());
    }

    @Test(priority = 2)
    public void testGetAppDetails() throws Exception {
        AppDetails result = client.getAppDetails(testApp.getName());

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(testApp.getName());
        assertThat(result.getDisplayName()).isEqualTo(testApp.getDisplayName());
        assertThat(result.getDescription()).isEqualTo(testApp.getDescription());
        assertThat(result.getAppStorageCapacity()).isEqualTo(testApp.getAppStorageCapacity());
        assertThat(result.getVersion()).isEqualTo(testApp.getVersion());
    }

    @Test(priority = 3)
    public void testGetAllAppDetails() throws Exception {
        AppResultSet result = client.getAllAppDetails();

        assertThat(result).isNotNull();
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

        AppDetails result = client.updateApp(currentAppName, testApp);

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(testApp.getName());
        assertThat(result.getDisplayName()).isEqualTo(testApp.getDisplayName());
        assertThat(result.getDescription()).isEqualTo(testApp.getDescription());
        assertThat(result.getAppStorageCapacity()).isEqualTo(testApp.getAppStorageCapacity());
    }

    @Test(priority = 5)
    public void testDeleteApp() throws Exception {
        Deleted result = client.deleteApp(testApp.getName());

        assertThat(result).isNotNull();
        assertThat(result.isDeleted()).isTrue();
    }
}