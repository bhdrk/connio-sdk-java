package com.connio.sdk.api.systemservices.datachannels;

import com.connio.sdk.api.auth.ConnioBasicCredentials;
import com.connio.sdk.api.AbstractClientMockServerTestCase;
import com.connio.sdk.api.model.Deleted;
import com.connio.sdk.api.systemservices.datachannels.model.*;
import com.connio.sdk.api.systemservices.datachannels.model.measurement.CustomMeasurementUnit;
import com.connio.sdk.api.systemservices.datachannels.model.measurement.MeasurementType;
import com.connio.sdk.http.utils.DateUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;

import static com.connio.sdk.api.TestUtils.resource;
import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by bdirik on 11.11.2014.
 */
@Test(suiteName = "ClientTests")
public class DataChannelClientTest extends AbstractClientMockServerTestCase {

    private IDataChannelClient client;

    @BeforeClass
    public void setUp() throws Exception {
        client = new DataChannelClient(ConnioBasicCredentials.DEFAULT_PROFILE, mockTransformer());
    }

    @Test()
    public void testCreateDataChannel() throws Exception {
        final String expectedRequestJson = resource("json/systemservices/datachannels/createDataChannel/request.json");
        final String mockResponseJson = resource("json/systemservices/datachannels/createDataChannel/response.json");

        final DataChannel requestContent = new DataChannel();
        requestContent.setName("TEST-DCHNL");
        requestContent.setChannelType(ChannelType.INPUT);
        requestContent.setMeasurementType(MeasurementType.CUSTOM);
        requestContent.setMeasurementUnit(CustomMeasurementUnit.BOOLEAN.getSymbol());

        final Date date = DateUtils.parseStringToDate("2014-11-12T08:57:53.149Z");

        final DataChannelDetails expectedResult = new DataChannelDetails();
        expectedResult.setSid("9C2A740FBE2A41420483279DA7B531BE57");
        expectedResult.setName("TEST-DCHNL");
        expectedResult.setAlarm(new Alarm());
        expectedResult.setUri("/v1/_apps/test-app/_channels/test-dchnl");
        expectedResult.setOwnerAppUri("/v1/_apps/test-app");
        expectedResult.setDatafeedUri("/v1/_apps/test-app/_data/test-dchnl");
        expectedResult.setAccountSid("AC739E3716D10E47A89C6C972FF97B5852");
        expectedResult.setAppSid("9A997596055A4941E59A8063EBCF288DD5");
        expectedResult.setChannelType(ChannelType.INPUT);
        expectedResult.setMeasurementType(MeasurementType.CUSTOM);
        expectedResult.setMeasurementUnit(CustomMeasurementUnit.BOOLEAN.getSymbol());
        expectedResult.setBounds(new Bounds());
        expectedResult.setRetentionPeriod(-1);
        expectedResult.setDateModified(date);
        expectedResult.setDateCreated(date);
        expectedResult.setBaseType(BaseType.BOOLEAN);


        pushResponse(mockResponseJson);

        final String appName = "TEST-APP";

        final DataChannelDetails result = client.createDataChannel(appName, requestContent);

        assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("POST");
        assertThat(request.getPath()).isEqualTo("/v1/_apps/" + appName + "/_channels");
        assertThat(request.getBody()).isEqualTo(expectedRequestJson);
    }

    @Test()
    public void testGetDataChannelDetails() throws Exception {
        final String mockResponseJson = resource("json/systemservices/datachannels/getDataChannelDetails/response.json");


        final Date date = DateUtils.parseStringToDate("2014-11-12T08:57:53.149Z");

        final DataChannelDetails expectedResult = new DataChannelDetails();
        expectedResult.setSid("9C2A740FBE2A41420483279DA7B531BE57");
        expectedResult.setName("TEST-DCHNL");
        expectedResult.setAlarm(new Alarm());
        expectedResult.setUri("/v1/_apps/test-app/_channels/test-dchnl");
        expectedResult.setOwnerAppUri("/v1/_apps/test-app");
        expectedResult.setDatafeedUri("/v1/_apps/test-app/_data/test-dchnl");
        expectedResult.setAccountSid("AC739E3716D10E47A89C6C972FF97B5852");
        expectedResult.setAppSid("9A997596055A4941E59A8063EBCF288DD5");
        expectedResult.setChannelType(ChannelType.INPUT);
        expectedResult.setMeasurementType(MeasurementType.CUSTOM);
        expectedResult.setMeasurementUnit(CustomMeasurementUnit.BOOLEAN.getSymbol());
        expectedResult.setBounds(new Bounds());
        expectedResult.setRetentionPeriod(-1);
        expectedResult.setDateModified(date);
        expectedResult.setDateCreated(date);
        expectedResult.setBaseType(BaseType.BOOLEAN);


        pushResponse(mockResponseJson);

        final String appName = "TEST-APP";
        final String channelName = "TEST-DCHNL";

        final DataChannelDetails result = client.getDataChannelDetails(appName, channelName);

        assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("GET");
        assertThat(request.getPath()).isEqualTo("/v1/_apps/" + appName + "/_channels/" + channelName);
        assertThat(request.getBody()).isNullOrEmpty();
    }

    @Test
    public void testGetAllDataChannelDetails() throws Exception {
        final String mockResponseJson = resource("json/systemservices/datachannels/getAllDataChannelDetails/response.json");

        final Date date1 = DateUtils.parseStringToDate("2014-11-12T08:57:53.149Z");
        final DataChannelDetails details1 = new DataChannelDetails();
        details1.setSid("9C2A740FBE2A41420483279DA7B531BE57");
        details1.setName("TEST-DCHNL");
        details1.setAlarm(new Alarm());
        details1.setUri("/v1/_apps/test-app/_channels/test-dchnl");
        details1.setOwnerAppUri("/v1/_apps/test-app");
        details1.setDatafeedUri("/v1/_apps/test-app/_data/test-dchnl");
        details1.setAccountSid("AC739E3716D10E47A89C6C972FF97B5852");
        details1.setAppSid("9A997596055A4941E59A8063EBCF288DD5");
        details1.setChannelType(ChannelType.INPUT);
        details1.setMeasurementType(MeasurementType.CUSTOM);
        details1.setMeasurementUnit(CustomMeasurementUnit.BOOLEAN.getSymbol());
        details1.setBounds(new Bounds());
        details1.setRetentionPeriod(-1);
        details1.setDateModified(date1);
        details1.setDateCreated(date1);
        details1.setBaseType(BaseType.BOOLEAN);

        final Date date2 = DateUtils.parseStringToDate("2014-11-12T13:46:48.304Z");
        final DataChannelDetails details2 = new DataChannelDetails();
        details2.setSid("9CF8860114E47A4B12A684DB486F41FA7C");
        details2.setName("TEST-DCHNL-2");
        details2.setAlarm(new Alarm());
        details2.setUri("/v1/_apps/test-app/_channels/test-dchnl-2");
        details2.setOwnerAppUri("/v1/_apps/test-app");
        details2.setDatafeedUri("/v1/_apps/test-app/_data/test-dchnl-2");
        details2.setAccountSid("AC739E3716D10E47A89C6C972FF97B5852");
        details2.setAppSid("9A997596055A4941E59A8063EBCF288DD5");
        details2.setChannelType(ChannelType.INPUT);
        details2.setMeasurementType(MeasurementType.CUSTOM);
        details2.setMeasurementUnit(CustomMeasurementUnit.BOOLEAN.getSymbol());
        details2.setBounds(new Bounds());
        details2.setRetentionPeriod(-1);
        details2.setDateModified(date2);
        details2.setDateCreated(date2);
        details2.setBaseType(BaseType.BOOLEAN);

        final List<DataChannelDetails> resultSet = new ArrayList<DataChannelDetails>();
        resultSet.add(details1);
        resultSet.add(details2);

        final DataChannelResultSet expectedResult = new DataChannelResultSet();
        expectedResult.setTotal(2);
        expectedResult.setItemCount(2);
        expectedResult.setSkip(0);
        expectedResult.setLimit(10);
        expectedResult.setResultSet(resultSet);


        pushResponse(mockResponseJson);

        final String appName = "TEST-APP";

        final DataChannelResultSet result = client.getAllDataChannelDetails(appName);

        assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("GET");
        assertThat(request.getPath()).isEqualTo("/v1/_apps/" + appName + "/_channels");
        assertThat(request.getBody()).isNullOrEmpty();
    }

    @Test
    public void testUpdateDataChannel() throws Exception {
        final String expectedRequestJson = resource("json/systemservices/datachannels/updateDataChannel/request.json");
        final String mockResponseJson = resource("json/systemservices/datachannels/updateDataChannel/response.json");


        final Map<String, String> alarmParamsMap = new HashMap<String, String>();
        alarmParamsMap.put("email", "test@test.com");

        final AlarmAction alarmAction = new AlarmAction();
        alarmAction.setName(AlarmActionName.EMAIL);
        alarmAction.setParams(alarmParamsMap);

        final Alarm alarm = new Alarm();
        alarm.setType(AlarmType.PASSIVE);
        alarm.setValue(10L);
        alarm.setAction(alarmAction);
        alarm.setDuration(Duration.MIN);

        final Map<String, String> boundParamsMap = new HashMap<String, String>();
        boundParamsMap.put("phone_number", "+905554442233");

        final BoundsAction boundsAction = new BoundsAction();
        boundsAction.setName(BoundsActionName.SMS);
        boundsAction.setParams(boundParamsMap);

        final Bounds bounds = new Bounds();
        bounds.setMin(1L);
        bounds.setMax(5L);
        bounds.setAction(boundsAction);

        final DataChannelUpdate requestContent = new DataChannelUpdate();
        requestContent.setName("TEST-DCHNL");
        requestContent.setAlarm(alarm);
        requestContent.setBounds(bounds);
        requestContent.setMeasurementUnit(CustomMeasurementUnit.NUMERIC.getSymbol());

        final Date date = DateUtils.parseStringToDate("2014-11-12T08:57:53.149Z");

        final DataChannelDetails expectedResult = new DataChannelDetails();
        expectedResult.setSid("9C2A740FBE2A41420483279DA7B531BE57");
        expectedResult.setName("TEST-DCHNL");
        expectedResult.setAlarm(alarm);
        expectedResult.setUri("/v1/_apps/test-app/_channels/test-dchnl");
        expectedResult.setOwnerAppUri("/v1/_apps/test-app");
        expectedResult.setDatafeedUri("/v1/_apps/test-app/_data/test-dchnl");
        expectedResult.setAccountSid("AC739E3716D10E47A89C6C972FF97B5852");
        expectedResult.setAppSid("9A997596055A4941E59A8063EBCF288DD5");
        expectedResult.setChannelType(ChannelType.INPUT);
        expectedResult.setMeasurementType(MeasurementType.CUSTOM);
        expectedResult.setMeasurementUnit(CustomMeasurementUnit.NUMERIC.getSymbol());
        expectedResult.setBounds(bounds);
        expectedResult.setRetentionPeriod(-1);
        expectedResult.setDateModified(date);
        expectedResult.setDateCreated(date);
        expectedResult.setBaseType(BaseType.NUMERIC);


        pushResponse(mockResponseJson);

        final String appName = "TEST-APP";
        final String channelName = "TEST-DHCL";


        final DataChannelDetails result = client.updateDataChannel(appName, channelName, requestContent);

        assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("PUT");
        assertThat(request.getPath()).isEqualTo("/v1/_apps/" + appName + "/_channels/" + channelName);
        assertThat(request.getBody()).isEqualTo(expectedRequestJson);
    }

    @Test
    public void testDeleteDataChannel() throws Exception {
        final String mockResponseJson = resource("json/systemservices/datachannels/deleteDataChannel/response.json");


        final Deleted expectedResult = new Deleted();
        expectedResult.setDeleted(true);


        pushResponse(mockResponseJson);

        final String appName = "TEST-APP";
        final String channelName = "TEST-DHCL";


        final Deleted result = client.deleteDataChannel(appName, channelName);

        assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("DELETE");
        assertThat(request.getPath()).isEqualTo("/v1/_apps/" + appName + "/_channels/" + channelName);
        assertThat(request.getBody()).isNullOrEmpty();
    }
}
