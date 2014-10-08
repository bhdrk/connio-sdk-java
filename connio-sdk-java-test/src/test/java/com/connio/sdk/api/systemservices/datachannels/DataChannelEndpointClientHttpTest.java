package com.connio.sdk.api.systemservices.datachannels;

import com.connio.sdk.api.model.Deleted;
import com.connio.sdk.api.systemservices.TestUtils;
import com.connio.sdk.api.systemservices.apps.IAppEndpointClient;
import com.connio.sdk.api.systemservices.apps.AppEndpointClient;
import com.connio.sdk.api.systemservices.apps.model.App;
import com.connio.sdk.api.systemservices.apps.model.AppDetails;
import com.connio.sdk.api.systemservices.apps.model.AppStateType;
import com.connio.sdk.api.systemservices.datachannels.model.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.connio.sdk.api.systemservices.datachannels.model.ChannelType.INPUT;
import static com.connio.sdk.api.systemservices.datachannels.model.measurement.MeasurementType.CUSTOM;
import static org.fest.assertions.api.Assertions.assertThat;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 24.09.2014
 */
@Test(suiteName = "HttpTests", testName = "DataChannelEndpoint")
public class DataChannelEndpointClientHttpTest {

    private IDataChannelEndpointClient client;

    private IAppEndpointClient appClient;

    private String testAppName;

    private DataChannel testDataChannel;

    @BeforeClass
    public void beforeClass() throws Exception {
        client = new DataChannelEndpointClient();
        appClient = new AppEndpointClient();
    }

    @Test
    public void createTestApp() throws Exception {
        App app = new App();
        app.setName(TestUtils.createNewName("TEST-APP"));
        app.setState(AppStateType.RUNNING);
        app.setVersion("v1.0");
        app.setDisplayName("TEST-APP");
        app.setAppStorageCapacity(100000L);

        AppDetails result = appClient.createApp(app);

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(app.getName());

        testAppName = result.getName();
    }

    @Test(dependsOnMethods = "createTestApp")
    public void testCreateDataChannel() throws Exception {
        testDataChannel = new DataChannel();
        testDataChannel.setName(TestUtils.createNewName("TEST-DCHNL"));
        testDataChannel.setMeasurementType(CUSTOM);
        testDataChannel.setMeasurementUnit("boolean");
        testDataChannel.setChannelType(INPUT);

        DataChannelDetails result = client.createDataChannel(testAppName, testDataChannel);

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(testDataChannel.getName());
        assertThat(result.getMeasurementType()).isEqualTo(testDataChannel.getMeasurementType());
        assertThat(result.getMeasurementUnit()).isEqualTo(testDataChannel.getMeasurementUnit());
        assertThat(result.getChannelType()).isEqualTo(testDataChannel.getChannelType());
    }

    @Test(dependsOnMethods = "testCreateDataChannel")
    public void testGetDataChannelDetails() throws Exception {
        DataChannelDetails result = client.getDataChannelDetails(testAppName, testDataChannel.getName());

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(testDataChannel.getName());
        assertThat(result.getMeasurementType()).isEqualTo(testDataChannel.getMeasurementType());
        assertThat(result.getMeasurementUnit()).isEqualTo(testDataChannel.getMeasurementUnit());
        assertThat(result.getChannelType()).isEqualTo(testDataChannel.getChannelType());
    }

    @Test(dependsOnMethods = "testCreateDataChannel")
    public void testGetAllDataChannelDetails() throws Exception {
        DataChannelResultSet result = client.getAllDataChannelDetails(testAppName);

        assertThat(result).isNotNull();
        assertThat(result.getItemCount()).isGreaterThan(0);
        assertThat(result.getTotal()).isGreaterThan(0);
        assertThat(result.getResultSet()).isNotEmpty();
    }

    @Test(dependsOnMethods = "testCreateDataChannel")
    public void testUpdateDataChannel() throws Exception {

        Map<String, String> alarmActionParams = new HashMap<String, String>(2);
        alarmActionParams.put("email", "test@test.com");

        AlarmAction alarmAction = new AlarmAction();
        alarmAction.setName(AlarmActionName.EMAIL);
        alarmAction.setParams(alarmActionParams);

        Alarm alarm = new Alarm();
        alarm.setType(AlarmType.PASSIVE);
        alarm.setValue(10L);
        alarm.setDuration(Duration.MIN);
        alarm.setAction(alarmAction);

        Map<String, String> boundsActionParams = new HashMap<String, String>(1);
        boundsActionParams.put("phone_number", "05554442233");

        BoundsAction boundsAction = new BoundsAction();
        boundsAction.setName(BoundsActionName.SMS);
        boundsAction.setParams(boundsActionParams);

        Bounds bounds = new Bounds();
        bounds.setMin(1L);
        bounds.setMax(5L);
        bounds.setAction(boundsAction);

        String currentDataChannelName = testDataChannel.getName();

        DataChannelUpdate dataChannelUpdate = new DataChannelUpdate();
        dataChannelUpdate.setName(TestUtils.createNewName("TEST-DCHNL"));
        dataChannelUpdate.setMeasurementUnit("numeric");
        dataChannelUpdate.setAlarm(alarm);
        dataChannelUpdate.setBounds(bounds);

        testDataChannel.setName(dataChannelUpdate.getName());

        DataChannelDetails result = client.updateDataChannel(testAppName, currentDataChannelName, dataChannelUpdate);

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(dataChannelUpdate.getName());
        assertThat(result.getMeasurementUnit()).isEqualTo(dataChannelUpdate.getMeasurementUnit());
        assertThat(result.getAlarm()).isEqualTo(alarm);
        assertThat(result.getBounds()).isEqualTo(bounds);
    }

    @Test(dependsOnMethods = "testUpdateDataChannel")
    public void testDeleteDataChannel() throws Exception {
        Deleted result = client.deleteDataChannel(testAppName, testDataChannel.getName());

        assertThat(result).isNotNull();
        assertThat(result.isDeleted()).isTrue();
    }

    @Test(dependsOnMethods = "testDeleteDataChannel")
    public void deleteTestApp() throws Exception {
        Deleted result = appClient.deleteApp(testAppName);

        assertThat(result).isNotNull();
        assertThat(result.isDeleted()).isTrue();
    }
}
