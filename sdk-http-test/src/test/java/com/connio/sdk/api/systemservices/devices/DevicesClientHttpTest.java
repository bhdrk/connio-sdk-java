package com.connio.sdk.api.systemservices.devices;

import com.connio.sdk.api.TestUtils;
import com.connio.sdk.api.model.Deleted;
import com.connio.sdk.api.model.GeoCoordinates;
import com.connio.sdk.api.model.Location;
import com.connio.sdk.api.systemservices.deviceprofiles.DeviceProfileClient;
import com.connio.sdk.api.systemservices.deviceprofiles.IDeviceProfileClient;
import com.connio.sdk.api.systemservices.deviceprofiles.model.DeviceProfile;
import com.connio.sdk.api.systemservices.deviceprofiles.model.DeviceProfileDetails;
import com.connio.sdk.api.systemservices.devices.model.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.connio.sdk.api.TestUtils.randomName;
import static com.connio.sdk.api.systemservices.devices.model.DeviceStatusType.CREATED;
import static org.fest.assertions.api.Assertions.assertThat;


@Test(suiteName = "HttpTests")
public class DevicesClientHttpTest {

    private IDevicesClient client;

    private IDeviceProfileClient profileClient;

    private String testProfileName;

    private Device testDevice;

    private String testDeviceSID;

    @BeforeMethod
    public void beforeClass() throws Exception {
        client = new DevicesClient();
        profileClient = new DeviceProfileClient();
    }

    @Test
    public void createDeviceProfile() throws Exception {
        DeviceProfile profile = new DeviceProfile();
        profile.setName(randomName("TEST-DVPRF"));
        profile.setClazz(randomName("CLASS"));
        profile.setSubclass(randomName("SUBCLASS"));
        profile.setVendor(randomName("VENDOR"));
        profile.setProduct(randomName("PRODUCT"));

        DeviceProfileDetails result = profileClient.createDeviceProfile(profile);

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(profile.getName());

        testProfileName = result.getName();
    }

    @Test(dependsOnMethods = "createDeviceProfile")
    public void testCreateDevice() throws Exception {
        testDevice = new Device();
        testDevice.setProfileName(testProfileName);
        testDevice.setTags(Arrays.asList("TAG1", "TAG2"));
        testDevice.setNotes("New test device");
        testDevice.setLoc(new Location("Istanbul", new GeoCoordinates(41.00527D, 28.976959999999963D)));
        testDevice.addCid(CidType._IMEI, TestUtils.generateIMEI());
        testDevice.setStatus(CREATED);

        DeviceDetails result = client.createDevice(testDevice);

        assertThat(result).isNotNull();
        assertThat(result.getProfileName()).isEqualToIgnoringCase(testDevice.getProfileName());
        assertThat(result.getTags()).containsAll(testDevice.getTags());
        assertThat(result.getNotes()).isEqualTo(testDevice.getNotes());
        assertThat(result.getLoc()).isEqualTo(testDevice.getLoc());
        assertThat(result.getStatus()).isEqualTo(testDevice.getStatus());
        assertThat(result.getCidMap()).isEqualTo(testDevice.getCidMap());

        testDeviceSID = result.getSid();
    }

    @Test(dependsOnMethods = "testCreateDevice")
    public void testGetDeviceDetailsBySID() throws Exception {
        DeviceDetails result = client.getDeviceDetails(testDeviceSID);

        assertThat(result).isNotNull();
        assertThat(result.getProfileName()).isEqualToIgnoringCase(testDevice.getProfileName());
        assertThat(result.getTags()).containsAll(testDevice.getTags());
        assertThat(result.getNotes()).isEqualTo(testDevice.getNotes());
        assertThat(result.getLoc()).isEqualTo(testDevice.getLoc());
        assertThat(result.getStatus()).isEqualTo(testDevice.getStatus());
        assertThat(result.getCidMap()).isEqualTo(testDevice.getCidMap());
    }

    @Test(dependsOnMethods = "testCreateDevice")
    public void testGetDeviceDetailsByCID() throws Exception {
        String imei = testDevice.getCidMap().get(CidType._IMEI);
        Cid cid = new Cid(testProfileName, CidType._IMEI, imei);
        DeviceDetails result = client.getDeviceDetails(cid);

        assertThat(result).isNotNull();
        assertThat(result.getProfileName()).isEqualToIgnoringCase(testDevice.getProfileName());
        assertThat(result.getTags()).containsAll(testDevice.getTags());
        assertThat(result.getNotes()).isEqualTo(testDevice.getNotes());
        assertThat(result.getLoc()).isEqualTo(testDevice.getLoc());
        assertThat(result.getStatus()).isEqualTo(testDevice.getStatus());
        assertThat(result.getCidMap()).isEqualTo(testDevice.getCidMap());
    }

    @Test(dependsOnMethods = "testCreateDevice")
    public void testGetAllDeviceDetails() throws Exception {
        DeviceResultSet result = client.getAllDeviceDetails();

        assertThat(result).isNotNull();
        assertThat(result.getItemCount()).isGreaterThan(0);
        assertThat(result.getTotal()).isGreaterThan(0);
        assertThat(result.getResultSet()).isNotEmpty();
    }

    @Test(dependsOnMethods = "testCreateDevice")
    public void testUpdateDeviceBySID() throws Exception {
        DeviceProfile deviceProfile = new DeviceProfile();
        deviceProfile.setName(randomName("TEST-DVPRF"));

        DeviceProfileDetails profileResult = profileClient.updateDeviceProfile(testProfileName, deviceProfile);
        testProfileName = profileResult.getName();

        testDevice.setProfileName(testProfileName);
        testDevice.setTags(Arrays.asList("TAG3", "TAG4"));
        testDevice.setNotes("Updated test device");
        testDevice.setLoc(new Location("Izmir", new GeoCoordinates(38.41885D, 27.12871999999993D)));
        testDevice.addCid(CidType._IMEI, TestUtils.generateIMEI());

        DeviceDetails result = client.updateDevice(testDeviceSID, testDevice);

        assertThat(result).isNotNull();
        assertThat(result.getProfileName()).isEqualToIgnoringCase(testDevice.getProfileName());
        assertThat(result.getTags()).containsAll(testDevice.getTags());
        assertThat(result.getNotes()).isEqualTo(testDevice.getNotes());
        assertThat(result.getLoc()).isEqualTo(testDevice.getLoc());
        assertThat(result.getCidMap()).isEqualTo(testDevice.getCidMap());
    }

    @Test(dependsOnMethods = "testCreateDevice", enabled = false)
    public void testUpdateDeviceByCID() throws Exception {
        DeviceProfile deviceProfile = new DeviceProfile();
        deviceProfile.setName(randomName("TEST-DVPRF"));

        final String imei = testDevice.getCidMap().get(CidType._IMEI);
        final Cid cid = new Cid(testProfileName, CidType._IMEI, imei);

        DeviceProfileDetails profileResult = profileClient.updateDeviceProfile(testProfileName, deviceProfile);
        testProfileName = profileResult.getName();

        testDevice.setProfileName(testProfileName);
        testDevice.setTags(Arrays.asList("TAG3", "TAG4"));
        testDevice.setNotes("Updated test device");
        testDevice.setLoc(new Location("Izmir", new GeoCoordinates(38.41885D, 27.12871999999993D)));
        testDevice.addCid(CidType._IMEI, TestUtils.generateIMEI());


        DeviceDetails result = client.updateDevice(cid, testDevice);

        assertThat(result).isNotNull();
        assertThat(result.getProfileName()).isEqualToIgnoringCase(testDevice.getProfileName());
        assertThat(result.getTags()).containsAll(testDevice.getTags());
        assertThat(result.getNotes()).isEqualTo(testDevice.getNotes());
        assertThat(result.getLoc()).isEqualTo(testDevice.getLoc());
        assertThat(result.getCidMap()).isEqualTo(testDevice.getCidMap());
    }

    @Test(dependsOnMethods = "testCreateDevice")
    public void testAccessKeyBySID() throws Exception {
        final DeviceAccessKey currentAccessKey = client.getAccessKey(testDeviceSID);

        assertThat(currentAccessKey).isNotNull();
        assertThat(currentAccessKey.getAuthToken()).isNotEmpty();
        assertThat(currentAccessKey.getAuthToken()).hasSize(32);


        final DeviceAccessKey newAccessKey = client.regenerateAccessKey(testDeviceSID);

        assertThat(newAccessKey).isNotNull();
        assertThat(newAccessKey.getAuthToken()).isNotEmpty();
        assertThat(newAccessKey.getAuthToken()).hasSize(32);

        assertThat(newAccessKey.getAuthToken()).isNotEqualTo(currentAccessKey.getAuthToken());


        final DeviceAccessKey lastAccessKey = client.getAccessKey(testDeviceSID);

        assertThat(lastAccessKey).isNotNull();
        assertThat(newAccessKey.getAuthToken()).isEqualTo(lastAccessKey.getAuthToken());
    }

    @Test(dependsOnMethods = "testCreateDevice", enabled = false)
    public void testAccessKeyByCID() throws Exception {
        final String imei = testDevice.getCidMap().get(CidType._IMEI);
        final Cid cid = new Cid(testProfileName, CidType._IMEI, imei);

        final DeviceAccessKey currentAccessKey = client.getAccessKey(cid);

        assertThat(currentAccessKey).isNotNull();
        assertThat(currentAccessKey.getAuthToken()).isNotEmpty();
        assertThat(currentAccessKey.getAuthToken()).hasSize(32);


        final DeviceAccessKey newAccessKey = client.regenerateAccessKey(cid);

        assertThat(newAccessKey).isNotNull();
        assertThat(newAccessKey.getAuthToken()).isNotEmpty();
        assertThat(newAccessKey.getAuthToken()).hasSize(32);

        assertThat(newAccessKey.getAuthToken()).isNotEqualTo(currentAccessKey.getAuthToken());


        final DeviceAccessKey lastAccessKey = client.getAccessKey(cid);

        assertThat(lastAccessKey).isNotNull();
        assertThat(newAccessKey.getAuthToken()).isEqualTo(lastAccessKey.getAuthToken());
    }

    @Test(dependsOnMethods = {
            "testUpdateDeviceBySID",
            //"testUpdateDeviceByCID",
            "testAccessKeyBySID",
            //"testAccessKeyByCID",
            "testGetDeviceDetailsBySID",
            "testGetDeviceDetailsByCID",
            "testGetAllDeviceDetails"
    })
    public void testDeleteDeviceBySID() throws Exception {
        Deleted result = client.deleteDevice(testDeviceSID);

        assertThat(result).isNotNull();
        assertThat(result.isDeleted()).isTrue();
    }

    @Test(dependsOnMethods = "testDeleteDeviceBySID", enabled = false)
    public void testDeleteDeviceByCID() throws Exception {
        String imei = testDevice.getCidMap().get(CidType._IMEI);
        Cid cid = new Cid(testProfileName, CidType._IMEI, imei);
        Deleted result = client.deleteDevice(cid);

        assertThat(result).isNotNull();
        assertThat(result.isDeleted()).isFalse();
    }

    @Test(dependsOnMethods = {
            "testDeleteDeviceBySID"
            //, "testDeleteDeviceByCID"
    })
    public void deleteProfile() throws Exception {
        Deleted result = profileClient.deleteDeviceProfile(testProfileName);

        assertThat(result).isNotNull();
        assertThat(result.isDeleted()).isTrue();
    }
}