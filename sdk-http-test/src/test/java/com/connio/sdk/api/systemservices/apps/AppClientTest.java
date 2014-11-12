package com.connio.sdk.api.systemservices.apps;

import com.connio.sdk.api.auth.ConnioCredentials;
import com.connio.sdk.api.AbstractClientMockServerTestCase;
import com.connio.sdk.api.model.Deleted;
import com.connio.sdk.api.systemservices.apps.model.App;
import com.connio.sdk.api.systemservices.apps.model.AppDetails;
import com.connio.sdk.api.systemservices.apps.model.AppResultSet;
import com.connio.sdk.api.systemservices.apps.model.AppStateType;
import com.connio.sdk.api.systemservices.datachannels.model.*;
import com.connio.sdk.api.systemservices.datachannels.model.measurement.LightMeasurementUnit;
import com.connio.sdk.api.systemservices.datachannels.model.measurement.MeasurementType;
import com.connio.sdk.api.systemservices.datachannels.model.measurement.RelativeHumidityMeasurementUnit;
import com.connio.sdk.api.systemservices.datachannels.model.measurement.TemperatureMeasurementUnit;
import org.fest.assertions.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.connio.sdk.api.TestUtils.resource;
import static com.connio.sdk.http.utils.DateUtils.parseStringToDate;
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


        final App requestContent = new App();
        requestContent.setName("TEST-APP");
        requestContent.setDisplayName("TEST APP");
        requestContent.setDescription("TEST APP DESC");
        requestContent.setVersion("v1.0");
        requestContent.setAppStorageCapacity(100000L);

        final Date date = parseStringToDate("2014-11-06T12:57:53.460Z");

        final AppDetails expectedResult = new AppDetails();
        expectedResult.setSid("9A11F838D02EF040F7A5C88ECFD7B5B438");
        expectedResult.setName("TEST-APP");
        expectedResult.setDescription("TEST APP DESC");
        expectedResult.setState(AppStateType.RUNNING);
        expectedResult.setVersion("v1.0");
        expectedResult.setUri("/v1/_apps/test-app");
        expectedResult.setUsageUri("/v1/_apps/test-app/_usage");
        expectedResult.setLogicUri("/v1/_apps/test-app/_logic");
        expectedResult.setLogsUri("/v1/_apps/test-app/_logs");
        expectedResult.setTriggersUri("/v1/_apps/test-app/_triggers");
        expectedResult.setDatafeedUri("/v1/_apps/test-app/_data");
        expectedResult.setDisplayName("TEST APP");
        expectedResult.setAccountSid("AC739E3716D10E47A89C6C972FF97B5852");
        expectedResult.setAppStorageCapacity(100000L);
        expectedResult.setAccAvailableStorage(1000000L);
        expectedResult.setDatachannels(new ArrayList<DataChannelDetails>());
        expectedResult.setDateModified(date);
        expectedResult.setDateCreated(date);


        pushResponse(mockResponseJson);

        final AppDetails result = client.createApp(requestContent);

        Assertions.assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("POST");
        assertThat(request.getPath()).isEqualTo("/v1/_apps");
        assertThat(request.getBody()).isEqualTo(expectedRequestJson);
    }

    @Test
    public void testGetAppDetails() throws Exception {
        final String mockResponseJson = resource("json/systemservices/apps/getAppDetails/response.json");


        final Date date = parseStringToDate("2014-11-06T15:51:06.203Z");

        final AppDetails expectedResult = new AppDetails();
        expectedResult.setSid("9A9914CC7BFF2E4F058B0FB0E49EBE560C");
        expectedResult.setName("TEST-APP");
        expectedResult.setDescription("TEST APP DESC");
        expectedResult.setState(AppStateType.RUNNING);
        expectedResult.setVersion("v1.0");
        expectedResult.setUri("/v1/_apps/test-app");
        expectedResult.setUsageUri("/v1/_apps/test-app/_usage");
        expectedResult.setLogicUri("/v1/_apps/test-app/_logic");
        expectedResult.setLogsUri("/v1/_apps/test-app/_logs");
        expectedResult.setTriggersUri("/v1/_apps/test-app/_triggers");
        expectedResult.setDatafeedUri("/v1/_apps/test-app/_data");
        expectedResult.setDisplayName("TEST APP");
        expectedResult.setAccountSid("AC739E3716D10E47A89C6C972FF97B5852");
        expectedResult.setAppStorageCapacity(100000L);
        expectedResult.setAccAvailableStorage(1000000L);
        expectedResult.setDateModified(date);
        expectedResult.setDateCreated(date);
        expectedResult.setDatachannels(new ArrayList<DataChannelDetails>());


        pushResponse(mockResponseJson);

        final String appName = "TEST-APP";

        final AppDetails result = client.getAppDetails(appName);

        Assertions.assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("GET");
        assertThat(request.getPath()).isEqualTo("/v1/_apps/" + appName);
        assertThat(request.getBody()).isNullOrEmpty();
    }

    @Test
    public void testGetAllAppDetails() throws Exception {
        final String mockResponseJson = resource("json/systemservices/apps/getAllAppDetails/response.json");


        final Date date1 = parseStringToDate("2014-11-06T15:46:12.740Z");

        final AppDetails app1 = new AppDetails();
        app1.setSid("9A32AF78AD9FFC4D9FA9E130F9C208C6A0");
        app1.setName("MYBANK");
        app1.setDescription("");
        app1.setState(AppStateType.RUNNING);
        app1.setVersion("1.0");
        app1.setUri("/v1/_apps/mybank");
        app1.setUsageUri("/v1/_apps/mybank/_usage");
        app1.setLogicUri("/v1/_apps/mybank/_logic");
        app1.setLogsUri("/v1/_apps/mybank/_logs");
        app1.setTriggersUri("/v1/_apps/mybank/_triggers");
        app1.setDatafeedUri("/v1/_apps/mybank/_data");
        app1.setDisplayName("MYBANK");
        app1.setAccountSid("AC739E3716D10E47A89C6C972FF97B5852");
        app1.setAppStorageCapacity(1000000L);
        app1.setAccAvailableStorage(1000000L);
        app1.setDateModified(date1);
        app1.setDateCreated(date1);


        final DataChannelDetails dc1 = new DataChannelDetails();
        dc1.setSid("9CC32710BA3C1546AB95784BEB43C5901C");
        dc1.setName("ATM.Temperature.1");
        dc1.setAlarm(new Alarm());
        dc1.setUri("/v1/_apps/mybank/_channels/atm.temperature.1");
        dc1.setOwnerAppUri("/v1/_apps/mybank");
        dc1.setDatafeedUri("/v1/_apps/mybank/_data/atm.temperature.1");
        dc1.setAccountSid("AC739E3716D10E47A89C6C972FF97B5852");
        dc1.setAppSid("9A32AF78AD9FFC4D9FA9E130F9C208C6A0");
        dc1.setChannelType(ChannelType.INPUT);
        dc1.setMeasurementType(MeasurementType.TEMPERATURE);
        dc1.setMeasurementUnit(TemperatureMeasurementUnit.C.getSymbol());
        dc1.setBounds(new Bounds());
        dc1.setRetentionPeriod(-1);
        dc1.setDateModified(date1);
        dc1.setDateCreated(date1);
        dc1.setBaseType(BaseType.NUMERIC);


        final DataChannelDetails dc2 = new DataChannelDetails();
        dc2.setSid("9C2D8C90F10C1546F785B14EB011FE95C0");
        dc2.setName("ATM.Humidity.1");
        dc2.setAlarm(new Alarm());
        dc2.setUri("/v1/_apps/mybank/_channels/atm.humidity.1");
        dc2.setOwnerAppUri("/v1/_apps/mybank");
        dc2.setDatafeedUri("/v1/_apps/mybank/_data/atm.humidity.1");
        dc2.setAccountSid("AC739E3716D10E47A89C6C972FF97B5852");
        dc2.setAppSid("9A32AF78AD9FFC4D9FA9E130F9C208C6A0");
        dc2.setChannelType(ChannelType.INPUT);
        dc2.setMeasurementType(MeasurementType.RELATIVEHUMIDITY);
        dc2.setMeasurementUnit(RelativeHumidityMeasurementUnit.PERCENTAGE.getSymbol());
        dc2.setBounds(new Bounds());
        dc2.setRetentionPeriod(-1);
        dc2.setDateModified(date1);
        dc2.setDateCreated(date1);
        dc2.setBaseType(BaseType.NUMERIC);


        final DataChannelDetails dc3 = new DataChannelDetails();
        dc3.setSid("9C6D4D0C2EB2284294AC2824B1679B56DC");
        dc3.setName("ATM.Ligth.1");
        dc3.setAlarm(new Alarm());
        dc3.setUri("/v1/_apps/mybank/_channels/atm.ligth.1");
        dc3.setOwnerAppUri("/v1/_apps/mybank");
        dc3.setDatafeedUri("/v1/_apps/mybank/_data/atm.ligth.1");
        dc3.setAccountSid("AC739E3716D10E47A89C6C972FF97B5852");
        dc3.setAppSid("9A32AF78AD9FFC4D9FA9E130F9C208C6A0");
        dc3.setChannelType(ChannelType.INPUT);
        dc3.setMeasurementType(MeasurementType.LIGHT);
        dc3.setMeasurementUnit(LightMeasurementUnit.LUMENS.getSymbol());
        dc3.setBounds(new Bounds());
        dc3.setRetentionPeriod(-1);
        dc3.setDateModified(date1);
        dc3.setDateCreated(date1);
        dc3.setBaseType(BaseType.NUMERIC);


        final List<DataChannelDetails> channels1 = new ArrayList<DataChannelDetails>();
        channels1.add(dc1);
        channels1.add(dc2);
        channels1.add(dc3);

        app1.setDatachannels(channels1);


        final Date date2 = parseStringToDate("2014-11-06T15:37:26.103Z");

        final AppDetails app2 = new AppDetails();
        app2.setSid("9AEF74155C12DE4BB492D696CF7BC9CD61");
        app2.setName("MYBANK2");
        app2.setDescription("");
        app2.setState(AppStateType.RUNNING);
        app2.setVersion("1.0");
        app2.setUri("/v1/_apps/mybank2");
        app2.setUsageUri("/v1/_apps/mybank2/_usage");
        app2.setLogicUri("/v1/_apps/mybank2/_logic");
        app2.setLogsUri("/v1/_apps/mybank2/_logs");
        app2.setTriggersUri("/v1/_apps/mybank2/_triggers");
        app2.setDatafeedUri("/v1/_apps/mybank2/_data");
        app2.setDisplayName("MYBANK2");
        app2.setAccountSid("AC739E3716D10E47A89C6C972FF97B5852");
        app2.setAppStorageCapacity(1000000L);
        app2.setAccAvailableStorage(1000000L);
        app2.setDateModified(date2);
        app2.setDateCreated(date2);


        final DataChannelDetails dc4 = new DataChannelDetails();
        dc4.setSid("9C51918E0425284AC2BB20489A7FC28C59");
        dc4.setName("ATM.Temperature.2");
        dc4.setAlarm(new Alarm());
        dc4.setUri("/v1/_apps/mybank2/_channels/atm.temperature.2");
        dc4.setOwnerAppUri("/v1/_apps/mybank2");
        dc4.setDatafeedUri("/v1/_apps/mybank2/_data/atm.temperature.2");
        dc4.setAccountSid("AC739E3716D10E47A89C6C972FF97B5852");
        dc4.setAppSid("9AEF74155C12DE4BB492D696CF7BC9CD61");
        dc4.setChannelType(ChannelType.INPUT);
        dc4.setMeasurementType(MeasurementType.TEMPERATURE);
        dc4.setMeasurementUnit(TemperatureMeasurementUnit.C.getSymbol());
        dc4.setBounds(new Bounds());
        dc4.setRetentionPeriod(-1);
        dc4.setDateModified(date2);
        dc4.setDateCreated(date2);
        dc4.setBaseType(BaseType.NUMERIC);


        final DataChannelDetails dc5 = new DataChannelDetails();
        dc5.setSid("9CE5DE65D6CCE348AD8BC7B3041D1B0EB7");
        dc5.setName("ATM.Humidity.2");
        dc5.setAlarm(new Alarm());
        dc5.setUri("/v1/_apps/mybank2/_channels/atm.humidity.2");
        dc5.setOwnerAppUri("/v1/_apps/mybank2");
        dc5.setDatafeedUri("/v1/_apps/mybank2/_data/atm.humidity.2");
        dc5.setAccountSid("AC739E3716D10E47A89C6C972FF97B5852");
        dc5.setAppSid("9AEF74155C12DE4BB492D696CF7BC9CD61");
        dc5.setChannelType(ChannelType.INPUT);
        dc5.setMeasurementType(MeasurementType.RELATIVEHUMIDITY);
        dc5.setMeasurementUnit(RelativeHumidityMeasurementUnit.PERCENTAGE.getSymbol());
        dc5.setBounds(new Bounds());
        dc5.setRetentionPeriod(-1);
        dc5.setDateModified(date2);
        dc5.setDateCreated(date2);
        dc5.setBaseType(BaseType.NUMERIC);


        final DataChannelDetails dc6 = new DataChannelDetails();
        dc6.setSid("9CF53629859FA9457E93761BC524CD5D9B");
        dc6.setName("ATM.Ligth.2");
        dc6.setAlarm(new Alarm());
        dc6.setUri("/v1/_apps/mybank2/_channels/atm.ligth.2");
        dc6.setOwnerAppUri("/v1/_apps/mybank2");
        dc6.setDatafeedUri("/v1/_apps/mybank2/_data/atm.ligth.2");
        dc6.setAccountSid("AC739E3716D10E47A89C6C972FF97B5852");
        dc6.setAppSid("9AEF74155C12DE4BB492D696CF7BC9CD61");
        dc6.setChannelType(ChannelType.INPUT);
        dc6.setMeasurementType(MeasurementType.LIGHT);
        dc6.setMeasurementUnit(LightMeasurementUnit.LUMENS.getSymbol());
        dc6.setBounds(new Bounds());
        dc6.setRetentionPeriod(-1);
        dc6.setDateModified(date2);
        dc6.setDateCreated(date2);
        dc6.setBaseType(BaseType.NUMERIC);


        final List<DataChannelDetails> channels2 = new ArrayList<DataChannelDetails>();
        channels2.add(dc4);
        channels2.add(dc5);
        channels2.add(dc6);

        app2.setDatachannels(channels2);


        final List<AppDetails> apps = new ArrayList<AppDetails>();
        apps.add(app1);
        apps.add(app2);


        final AppResultSet expectedResult = new AppResultSet();
        expectedResult.setItemCount(apps.size());
        expectedResult.setTotal(apps.size());
        expectedResult.setSkip(0);
        expectedResult.setLimit(0);
        expectedResult.setResultSet(apps);


        pushResponse(mockResponseJson);

        final AppResultSet result = client.getAllAppDetails();

        Assertions.assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("GET");
        assertThat(request.getPath()).isEqualTo("/v1/_apps");
        assertThat(request.getBody()).isNullOrEmpty();
    }

    @Test
    public void testUpdateApp() throws Exception {
        final String expectedRequestJson = resource("json/systemservices/apps/updateApp/request.json");
        final String mockResponseJson = resource("json/systemservices/apps/updateApp/response.json");


        final App requestContent = new App();
        requestContent.setName("TEST-APP");
        requestContent.setDisplayName("UPDATED TEST APP");
        requestContent.setDescription("UPDATED TEST APP DESC");
        requestContent.setVersion("v2.0");
        requestContent.setAppStorageCapacity(500000L);
        requestContent.setState(AppStateType.STOPPED);


        final Date date = parseStringToDate("2014-11-07T14:25:44.308Z");

        final AppDetails expectedResult = new AppDetails();
        expectedResult.setSid("9A479B8C40F6874B27B2F33FA7ED69EC6D");
        expectedResult.setName("TEST-APP");
        expectedResult.setDescription("UPDATED TEST APP DESC");
        expectedResult.setState(AppStateType.STOPPED);
        expectedResult.setVersion("v2.0");
        expectedResult.setUri("/v1/_apps/test-app");
        expectedResult.setUsageUri("/v1/_apps/test-app/_usage");
        expectedResult.setLogicUri("/v1/_apps/test-app/_logic");
        expectedResult.setLogsUri("/v1/_apps/test-app/_logs");
        expectedResult.setTriggersUri("/v1/_apps/test-app/_triggers");
        expectedResult.setDatafeedUri("/v1/_apps/test-app/_data");
        expectedResult.setDisplayName("UPDATED TEST APP");
        expectedResult.setAccountSid("AC739E3716D10E47A89C6C972FF97B5852");
        expectedResult.setAppStorageCapacity(500000L);
        expectedResult.setAccAvailableStorage(1000000L);
        expectedResult.setDateModified(date);
        expectedResult.setDateCreated(date);
        expectedResult.setDatachannels(new ArrayList<DataChannelDetails>());


        pushResponse(mockResponseJson);

        final String appName = "TEST-APP";

        final AppDetails result = client.updateApp(appName, requestContent);

        Assertions.assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("PUT");
        assertThat(request.getPath()).isEqualTo("/v1/_apps/" + appName);
        assertThat(request.getBody()).isEqualTo(expectedRequestJson);
    }

    @Test
    public void testDeleteApp() throws Exception {
        final String mockResponseJson = resource("json/systemservices/apps/deleteApp/response.json");


        final Deleted expectedResult = new Deleted();
        expectedResult.setDeleted(true);


        pushResponse(mockResponseJson);

        final String appName = "TEST-APP";

        final Deleted result = client.deleteApp(appName);

        Assertions.assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("DELETE");
        assertThat(request.getPath()).isEqualTo("/v1/_apps/" + appName);
        assertThat(request.getBody()).isNullOrEmpty();
    }
}
