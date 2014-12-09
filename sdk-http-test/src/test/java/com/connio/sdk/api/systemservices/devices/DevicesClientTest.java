package com.connio.sdk.api.systemservices.devices;

import com.connio.sdk.api.AbstractClientMockServerTestCase;
import com.connio.sdk.api.auth.ConnioCredentials;
import com.connio.sdk.api.model.Deleted;
import com.connio.sdk.api.model.GeoCoordinates;
import com.connio.sdk.api.model.Location;
import com.connio.sdk.api.systemservices.devices.model.*;
import com.connio.sdk.http.utils.DateUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;

import static com.connio.sdk.api.TestUtils.resource;
import static org.fest.assertions.api.Assertions.assertThat;


@Test(suiteName = "ClientTests", groups = "client")
public class DevicesClientTest extends AbstractClientMockServerTestCase {

    private IDevicesClient client;

    @BeforeClass
    public void beforeClass() throws Exception {
        client = new DevicesClient(ConnioCredentials.DEFAULT_PROFILE, mockTransformer());
    }

    @Test
    public void testCreateDevice() throws Exception {
        final String expectedRequestJson = resource("json/systemservices/devices/createDevice/request.json");
        final String mockResponseJson = resource("json/systemservices/devices/createDevice/response.json");


        final Device requestContent = new Device();
        requestContent.setProfileName("TEST-DVPRF");
        requestContent.addCid(CidType._IMEI, "520278081911870");
        requestContent.setStatus(DeviceStatusType.CREATED);
        requestContent.setLoc(new Location("Istanbul", new GeoCoordinates(41.00527, 28.976959999999963)));
        requestContent.setNotes("New test device");
        requestContent.setTags(Arrays.asList("TAG1", "TAG2"));

        Map<CidType, String> cidMap = new HashMap<CidType, String>();
        cidMap.put(CidType._IMEI, "520278081911870");

        final Date date = DateUtils.parseStringToDate("2014-11-12T16:32:31.719Z");

        final DeviceDetails expectedResult = new DeviceDetails();
        expectedResult.setSid("1D0F7A512E02004BCEB5154CAF043CC2CE");
        expectedResult.setStatus(DeviceStatusType.CREATED);
        expectedResult.setNotes("New test device");
        expectedResult.setTags(Arrays.asList("TAG1", "TAG2"));
        expectedResult.setUri("/v1/_devices/1d0f7a512e02004bceb5154caf043cc2ce");
        expectedResult.setAccessKeyUri("/v1/_devices/1d0f7a512e02004bceb5154caf043cc2ce/_keys");
        expectedResult.setProfileName("test-dvprf");
        expectedResult.setCidMap(cidMap);
        expectedResult.setAccountSid("AC739E3716D10E47A89C6C972FF97B5852");
        expectedResult.setLoc(new Location("Istanbul", new GeoCoordinates(41.00527, 28.976959999999963)));
        expectedResult.setDateModified(date);
        expectedResult.setDateCreated(date);


        pushResponse(mockResponseJson);

        final DeviceDetails result = client.createDevice(requestContent);

        assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("POST");
        assertThat(request.getPath()).isEqualTo("/v1/_devices");
        assertThat(request.getBody()).isEqualTo(expectedRequestJson);
    }

    @Test
    public void testGetDeviceDetailsBySID() throws Exception {
        final String mockResponseJson = resource("json/systemservices/devices/getDeviceDetails/response.json");


        final Map<CidType, String> cidMap = new HashMap<CidType, String>();
        cidMap.put(CidType._IMEI, "520278081911870");

        final Date date = DateUtils.parseStringToDate("2014-11-12T16:32:31.719Z");

        final DeviceDetails expectedResult = new DeviceDetails();
        expectedResult.setSid("1D0F7A512E02004BCEB5154CAF043CC2CE");
        expectedResult.setStatus(DeviceStatusType.CREATED);
        expectedResult.setNotes("New test device");
        expectedResult.setTags(Arrays.asList("TAG1", "TAG2"));
        expectedResult.setUri("/v1/_devices/1d0f7a512e02004bceb5154caf043cc2ce");
        expectedResult.setAccessKeyUri("/v1/_devices/1d0f7a512e02004bceb5154caf043cc2ce/_keys");
        expectedResult.setProfileName("test-dvprf");
        expectedResult.setCidMap(cidMap);
        expectedResult.setAccountSid("AC739E3716D10E47A89C6C972FF97B5852");
        expectedResult.setLoc(new Location("Istanbul", new GeoCoordinates(41.00527, 28.976959999999963)));
        expectedResult.setDateModified(date);
        expectedResult.setDateCreated(date);


        pushResponse(mockResponseJson);

        final String sid = "1D0F7A512E02004BCEB5154CAF043CC2CE";

        final DeviceDetails result = client.getDeviceDetails(sid);

        assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("GET");
        assertThat(request.getPath()).isEqualTo("/v1/_devices/" + sid);
        assertThat(request.getBody()).isNullOrEmpty();
    }

    @Test
    public void testGetDeviceDetailsByCID() throws Exception {
        final String mockResponseJson = resource("json/systemservices/devices/getDeviceDetails/response.json");


        final String profileName = "TEST-DVPRF";
        final String IMEI = "520278081911870";
        final CidType cidType = CidType._IMEI;

        final Map<CidType, String> cidMap = new HashMap<CidType, String>();
        cidMap.put(cidType, IMEI);

        final Date date = DateUtils.parseStringToDate("2014-11-12T16:32:31.719Z");

        final DeviceDetails expectedResult = new DeviceDetails();
        expectedResult.setSid("1D0F7A512E02004BCEB5154CAF043CC2CE");
        expectedResult.setStatus(DeviceStatusType.CREATED);
        expectedResult.setNotes("New test device");
        expectedResult.setTags(Arrays.asList("TAG1", "TAG2"));
        expectedResult.setUri("/v1/_devices/1d0f7a512e02004bceb5154caf043cc2ce");
        expectedResult.setAccessKeyUri("/v1/_devices/1d0f7a512e02004bceb5154caf043cc2ce/_keys");
        expectedResult.setProfileName("test-dvprf");
        expectedResult.setCidMap(cidMap);
        expectedResult.setAccountSid("AC739E3716D10E47A89C6C972FF97B5852");
        expectedResult.setLoc(new Location("Istanbul", new GeoCoordinates(41.00527, 28.976959999999963)));
        expectedResult.setDateModified(date);
        expectedResult.setDateCreated(date);


        pushResponse(mockResponseJson);

        final Cid cid = new Cid(profileName, cidType, IMEI);

        final DeviceDetails result = client.getDeviceDetails(cid);

        assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("GET");
        assertThat(request.getPath()).isEqualTo("/v1/_devices/" + profileName + "/" + cidType + "/" + IMEI);
        assertThat(request.getBody()).isNullOrEmpty();
    }

    @Test
    public void testGetAllDeviceDetails() throws Exception {
        final String mockResponseJson = resource("json/systemservices/devices/getAllDeviceDetails/response.json");

        final Date date1 = DateUtils.parseStringToDate("2014-11-12T16:32:31.719Z");
        final Date date2 = DateUtils.parseStringToDate("2014-11-06T15:46:13.567Z");

        final Map<CidType, String> cidMap1 = new HashMap<CidType, String>();
        cidMap1.put(CidType._IMEI, "520278081911870");

        final Map<CidType, String> cidMap2 = new HashMap<CidType, String>();
        cidMap2.put(CidType._ID, "869ef16e-ef2a-403f-8882-d540d1cd3f87");


        final DeviceDetails details1 = new DeviceDetails();
        details1.setSid("1D0F7A512E02004BCEB5154CAF043CC2CE");
        details1.setStatus(DeviceStatusType.CREATED);
        details1.setNotes("New test device");
        details1.setTags(Arrays.asList("TAG1", "TAG2"));
        details1.setUri("/v1/_devices/1d0f7a512e02004bceb5154caf043cc2ce");
        details1.setAccessKeyUri("/v1/_devices/1d0f7a512e02004bceb5154caf043cc2ce/_keys");
        details1.setProfileName("test-dvprf");
        details1.setCidMap(cidMap1);
        details1.setAccountSid("AC739E3716D10E47A89C6C972FF97B5852");
        details1.setLoc(new Location("Istanbul", new GeoCoordinates(41.00527, 28.976959999999963)));
        details1.setDateModified(date1);
        details1.setDateCreated(date1);

        final DeviceDetails details2 = new DeviceDetails();
        details2.setSid("1D28EFC3EB0D36473BA62081421BF88F12");
        details2.setStatus(DeviceStatusType.CREATED);
        details2.setNotes("New test device");
        details2.setTags(Arrays.asList("TAG1", "TAG2"));
        details2.setUri("/v1/_devices/1d28efc3eb0d36473ba62081421bf88f12");
        details2.setAccessKeyUri("/v1/_devices/1d28efc3eb0d36473ba62081421bf88f12/_keys");
        details2.setProfileName("test-dvprf");
        details2.setCidMap(cidMap2);
        details2.setAccountSid("AC739E3716D10E47A89C6C972FF97B5852");
        details2.setLoc(new Location("Istanbul", new GeoCoordinates(41.00527, 28.976959999999963)));
        details2.setDateModified(date2);
        details2.setDateCreated(date2);

        final List<DeviceDetails> devices = new ArrayList<DeviceDetails>();
        devices.add(details1);
        devices.add(details2);

        final DeviceResultSet expectedResult = new DeviceResultSet();
        expectedResult.setTotal(2);
        expectedResult.setItemCount(2);
        expectedResult.setSkip(0);
        expectedResult.setLimit(10);
        expectedResult.setResultSet(devices);


        pushResponse(mockResponseJson);

        final DeviceResultSet result = client.getAllDeviceDetails();

        assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("GET");
        assertThat(request.getPath()).isEqualTo("/v1/_devices");
        assertThat(request.getBody()).isNullOrEmpty();
    }

    @Test
    public void testUpdateDeviceBySID() throws Exception {
        final String expectedRequestJson = resource("json/systemservices/devices/updateDevice/request.json");
        final String mockResponseJson = resource("json/systemservices/devices/updateDevice/response.json");


        final CidType cidType = CidType._IMEI;
        final String IMEI = "520278081911870";

        final Device requestContent = new Device();
        requestContent.setProfileName("TEST-DVPRF");
        requestContent.addCid(cidType, IMEI);
        requestContent.setStatus(DeviceStatusType.CREATED);
        requestContent.setLoc(new Location("Istanbul", new GeoCoordinates(41.00527, 28.976959999999963)));
        requestContent.setNotes("New test device");
        requestContent.setTags(Arrays.asList("TAG1", "TAG2"));

        Map<CidType, String> cidMap = new HashMap<CidType, String>();
        cidMap.put(cidType, IMEI);

        final Date date = DateUtils.parseStringToDate("2014-11-12T16:32:31.719Z");

        final DeviceDetails expectedResult = new DeviceDetails();
        expectedResult.setSid("1D0F7A512E02004BCEB5154CAF043CC2CE");
        expectedResult.setStatus(DeviceStatusType.CREATED);
        expectedResult.setNotes("New test device");
        expectedResult.setTags(Arrays.asList("TAG1", "TAG2"));
        expectedResult.setUri("/v1/_devices/1d0f7a512e02004bceb5154caf043cc2ce");
        expectedResult.setAccessKeyUri("/v1/_devices/1d0f7a512e02004bceb5154caf043cc2ce/_keys");
        expectedResult.setProfileName("test-dvprf");
        expectedResult.setCidMap(cidMap);
        expectedResult.setAccountSid("AC739E3716D10E47A89C6C972FF97B5852");
        expectedResult.setLoc(new Location("Istanbul", new GeoCoordinates(41.00527, 28.976959999999963)));
        expectedResult.setDateModified(date);
        expectedResult.setDateCreated(date);


        pushResponse(mockResponseJson);

        final String sid = "1D0F7A512E02004BCEB5154CAF043CC2CE";

        final DeviceDetails result = client.updateDevice(sid, requestContent);

        assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("PUT");
        assertThat(request.getPath()).isEqualTo("/v1/_devices/" + sid);
        assertThat(request.getBody()).isEqualTo(expectedRequestJson);
    }

    @Test
    public void testUpdateDeviceByCID() throws Exception {
        final String expectedRequestJson = resource("json/systemservices/devices/updateDevice/request.json");
        final String mockResponseJson = resource("json/systemservices/devices/updateDevice/response.json");


        final String profileName = "TEST-DVPRF";
        final CidType cidType = CidType._IMEI;
        final String IMEI = "520278081911870";


        final Device requestContent = new Device();
        requestContent.setProfileName("TEST-DVPRF");
        requestContent.addCid(cidType, IMEI);
        requestContent.setStatus(DeviceStatusType.CREATED);
        requestContent.setLoc(new Location("Istanbul", new GeoCoordinates(41.00527, 28.976959999999963)));
        requestContent.setNotes("New test device");
        requestContent.setTags(Arrays.asList("TAG1", "TAG2"));


        Map<CidType, String> cidMap = new HashMap<CidType, String>();
        cidMap.put(cidType, IMEI);

        final Date date = DateUtils.parseStringToDate("2014-11-12T16:32:31.719Z");

        final DeviceDetails expectedResult = new DeviceDetails();
        expectedResult.setSid("1D0F7A512E02004BCEB5154CAF043CC2CE");
        expectedResult.setStatus(DeviceStatusType.CREATED);
        expectedResult.setNotes("New test device");
        expectedResult.setTags(Arrays.asList("TAG1", "TAG2"));
        expectedResult.setUri("/v1/_devices/1d0f7a512e02004bceb5154caf043cc2ce");
        expectedResult.setAccessKeyUri("/v1/_devices/1d0f7a512e02004bceb5154caf043cc2ce/_keys");
        expectedResult.setProfileName("test-dvprf");
        expectedResult.setCidMap(cidMap);
        expectedResult.setAccountSid("AC739E3716D10E47A89C6C972FF97B5852");
        expectedResult.setLoc(new Location("Istanbul", new GeoCoordinates(41.00527, 28.976959999999963)));
        expectedResult.setDateModified(date);
        expectedResult.setDateCreated(date);


        pushResponse(mockResponseJson);

        Cid cid = new Cid(profileName, cidType, IMEI);

        final DeviceDetails result = client.updateDevice(cid, requestContent);

        assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("PUT");
        assertThat(request.getPath()).isEqualTo("/v1/_devices/" + profileName + "/" + cidType + "/" + IMEI);
        assertThat(request.getBody()).isEqualTo(expectedRequestJson);
    }

    @Test
    public void testDeleteDeviceBySID() throws Exception {
        final String mockResponseJson = resource("json/systemservices/devices/deleteDevice/response.json");


        final Deleted expectedResult = new Deleted();
        expectedResult.setDeleted(true);


        pushResponse(mockResponseJson);

        final String sid = "1D0F7A512E02004BCEB5154CAF043CC2CE";

        final Deleted result = client.deleteDevice(sid);

        assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("DELETE");
        assertThat(request.getPath()).isEqualTo("/v1/_devices/" + sid);
        assertThat(request.getBody()).isNullOrEmpty();
    }

    @Test
    public void testDeleteDeviceByCID() throws Exception {
        final String mockResponseJson = resource("json/systemservices/devices/deleteDevice/response.json");


        final String profileName = "TEST-DVPRF";
        final CidType cidType = CidType._IMEI;
        final String IMEI = "520278081911870";

        final Deleted expectedResult = new Deleted();
        expectedResult.setDeleted(true);


        pushResponse(mockResponseJson);

        final Cid cid = new Cid(profileName, cidType, IMEI);

        final Deleted result = client.deleteDevice(cid);

        assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("DELETE");
        assertThat(request.getPath()).isEqualTo("/v1/_devices/" + profileName + "/" + cidType + "/" + IMEI);
        assertThat(request.getBody()).isNullOrEmpty();
    }

}