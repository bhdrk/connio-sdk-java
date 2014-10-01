package com.connio.sdk.api.systemservices.devices;

import com.connio.sdk.api.systemservices.TestUtils;
import com.connio.sdk.api.systemservices.deviceprofiles.DeviceProfileEndpointClient;
import com.connio.sdk.api.systemservices.deviceprofiles.DeviceProfileEndpointClientImpl;
import com.connio.sdk.api.systemservices.deviceprofiles.model.DeviceProfile;
import com.connio.sdk.api.systemservices.deviceprofiles.model.DeviceProfileDetails;
import com.connio.sdk.api.systemservices.devices.model.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.connio.sdk.api.systemservices.devices.model.DeviceStatusType.CREATED;
import static org.fest.assertions.api.Assertions.assertThat;


@Test(suiteName = "HttpTests", testName = "DeviceEndpoint")
public class DevicesEndpointClientHttpTest {

    private DevicesEndpointClient client;

    private DeviceProfileEndpointClient profileClient;

    private String testProfileName;

    @BeforeMethod
    public void beforeClass() throws Exception {
        client = new DevicesEndpointClientImpl();
        profileClient = new DeviceProfileEndpointClientImpl();
    }

    @Test(priority = 1, enabled = false)
    public void createDeviceProfile() throws Exception {
        DeviceProfile profile = new DeviceProfile();
        profile.setName(TestUtils.createNewName("TEST-DVPRF"));
        profile.setClazz(TestUtils.createNewName("CLASS"));
        profile.setSubclass(TestUtils.createNewName("SUBCLASS"));
        profile.setVendor(TestUtils.createNewName("VENDOR"));
        profile.setProduct(TestUtils.createNewName("PRODUCT"));

        DeviceProfileDetails result = profileClient.createDeviceProfile(profile);

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(profile.getName());

        testProfileName = result.getName();
    }

    @Test(priority = 2, enabled = false)
    public void testCreateDevice() throws Exception {
        Device device = new Device();
        device.setProfileName(testProfileName);
        device.setTags(Arrays.asList("TAG1", "TAG2"));
        device.setNotes("New test device");
        device.setLoc(new Location("Istanbul", new GeoCoordinates(41.00527D, 28.976959999999963D)));
        device.addCid(CidType._IMEI, TestUtils.generateIMEI());
        device.setStatus(CREATED);

        DeviceDetails result = client.createDevice(device);

        assertThat(result).isNotNull();
        assertThat(result.getProfileName()).isEqualTo(device.getProfileName());
        assertThat(result.getTags()).isEqualTo(device.getTags());
        assertThat(result.getNotes()).isEqualTo(device.getNotes());
        assertThat(result.getLoc()).isEqualTo(device.getLoc());
    }
}