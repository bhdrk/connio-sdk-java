package com.connio.sdk.api.systemservices.datachannel;

import com.connio.sdk.api.model.Deleted;
import com.connio.sdk.api.systemservices.TestUtils;
import com.connio.sdk.api.systemservices.apps.AppEndpointClientImpl;
import com.connio.sdk.api.systemservices.apps.model.*;
import com.connio.sdk.api.systemservices.datachannels.DataChannelEndpointClientImpl;
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
@Test(groups = "httptest")
public class DataChannelEndpointClientHttpTest {

    private DataChannelEndpointClientImpl client;

    private AppEndpointClientImpl appClient;

    private String testAppName;

    private DataChannel testDataChannel;

    @BeforeClass
    public void setUp() throws Exception {
        client = new DataChannelEndpointClientImpl();
        appClient = new AppEndpointClientImpl();
    }

    @Test(priority = 0)
    public void createTestApp() throws Exception {
        App app = new App();
        app.setName(TestUtils.createNewName("TEST-APP"));
        app.setState(StateType.RUNNING);
        app.setVersion("v1.0");
        app.setDisplayName("TEST-APP");
        app.setAppStorageCapacity(100000L);

        CreateAppRequest request = new CreateAppRequest(app);
        CreateAppResponse response = appClient.createApp(request);

        assertThat(response).isNotNull();
        assertThat(response.getResult()).isNotNull();

        AppDetails result = response.getResult();

        assertThat(result.getName()).isEqualTo(app.getName());

        testAppName = result.getName();
    }

    @Test(priority = 1)
    public void testCreateDataChannel() throws Exception {
        testDataChannel = new DataChannel();
        testDataChannel.setName(TestUtils.createNewName("TEST-DCHNL"));
        testDataChannel.setMeasurementType(CUSTOM);
        testDataChannel.setMeasurementUnit("boolean");
        testDataChannel.setChannelType(INPUT);

        CreateDataChannelRequest request = new CreateDataChannelRequest(testAppName, testDataChannel);
        CreateDataChannelResponse response = client.createDataChannel(request);

        assertThat(response).isNotNull();
        assertThat(response.getResult()).isNotNull();

        DataChannelDetails result = response.getResult();

        assertThat(result.getName()).isEqualTo(testDataChannel.getName());
        assertThat(result.getMeasurementType()).isEqualTo(testDataChannel.getMeasurementType());
        assertThat(result.getMeasurementUnit()).isEqualTo(testDataChannel.getMeasurementUnit());
        assertThat(result.getChannelType()).isEqualTo(testDataChannel.getChannelType());
    }

    @Test(priority = 2)
    public void testGetDataChannelDetails() throws Exception {
        GetDataChannelDetailsRequest request = new GetDataChannelDetailsRequest(testAppName, testDataChannel.getName());
        GetDataChannelDetailsResponse response = client.getDataChannelDetails(request);

        assertThat(response).isNotNull();
        assertThat(response.getResult()).isNotNull();

        DataChannelDetails result = response.getResult();

        assertThat(result.getName()).isEqualTo(testDataChannel.getName());
        assertThat(result.getMeasurementType()).isEqualTo(testDataChannel.getMeasurementType());
        assertThat(result.getMeasurementUnit()).isEqualTo(testDataChannel.getMeasurementUnit());
        assertThat(result.getChannelType()).isEqualTo(testDataChannel.getChannelType());
    }

    @Test(priority = 3)
    public void testGetAllDataChannelDetails() throws Exception {
        GetAllDataChannelDetailsRequest request = new GetAllDataChannelDetailsRequest(testAppName);
        GetAllDataChannelDetailsResponse response = client.getAllDataChannelDetails(request);

        assertThat(response).isNotNull();
        assertThat(response.getResult()).isNotNull();

        DataChannelResultSet result = response.getResult();

        assertThat(result.getItemCount()).isGreaterThan(0);
        assertThat(result.getTotal()).isGreaterThan(0);
        assertThat(result.getResultSet()).isNotEmpty();
    }

    @Test(priority = 4)
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

        UpdateDataChannelRequest request = new UpdateDataChannelRequest(testAppName, currentDataChannelName, dataChannelUpdate);
        UpdateDataChannelResponse response = client.updateDataChannel(request);

        assertThat(response).isNotNull();
        assertThat(response.getResult()).isNotNull();

        DataChannelDetails result = response.getResult();

        assertThat(result.getName()).isEqualTo(dataChannelUpdate.getName());
        assertThat(result.getMeasurementUnit()).isEqualTo(dataChannelUpdate.getMeasurementUnit());
        assertThat(result.getAlarm()).isEqualTo(alarm);
        assertThat(result.getBounds()).isEqualTo(bounds);
    }

    @Test(priority = 5)
    public void testDeleteDataChannel() throws Exception {
        DeleteDataChannelRequest request = new DeleteDataChannelRequest(testAppName, testDataChannel.getName());
        DeleteDataChannelResponse response = client.deleteDataChannel(request);

        assertThat(response).isNotNull();
        assertThat(response.getResult()).isNotNull();

        Deleted result = response.getResult();

        assertThat(result.isDeleted()).isTrue();
    }

    @Test(priority = 6)
    public void deleteTestApp() throws Exception {
        DeleteAppRequest request = new DeleteAppRequest(testAppName);
        DeleteAppResponse response = appClient.deleteApp(request);

        assertThat(response).isNotNull();
        assertThat(response.getResult()).isNotNull();

        Deleted result = response.getResult();

        assertThat(result.isDeleted()).isTrue();
    }
}
