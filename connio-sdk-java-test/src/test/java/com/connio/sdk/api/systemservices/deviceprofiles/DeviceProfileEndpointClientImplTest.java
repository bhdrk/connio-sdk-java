package com.connio.sdk.api.systemservices.deviceprofiles;

import com.connio.sdk.api.model.Deleted;
import com.connio.sdk.api.systemservices.TestUtils;
import com.connio.sdk.api.systemservices.deviceprofiles.model.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 25.09.2014
 */
@Test(groups = "httptest")
public class DeviceProfileEndpointClientImplTest {

    private DeviceProfileEndpointClientImpl client;

    private DeviceProfile testDeviceProfile;

    @BeforeClass
    public void setUp() throws Exception {
        client = new DeviceProfileEndpointClientImpl();
    }

    @Test(priority = 1)
    public void testCreateDeviceProfile() throws Exception {
        testDeviceProfile = new DeviceProfile();
        testDeviceProfile.setName(TestUtils.createNewName("TEST-DVPRF"));
        testDeviceProfile.setClazz(TestUtils.createNewName("CLASS"));
        testDeviceProfile.setSubclass(TestUtils.createNewName("SUBCLASS"));
        testDeviceProfile.setVendor(TestUtils.createNewName("VENDOR"));
        testDeviceProfile.setProduct(TestUtils.createNewName("PRODUCT"));

        CreateDeviceProfileRequest request = new CreateDeviceProfileRequest(testDeviceProfile);
        CreateDeviceProfileResponse response = client.createDeviceProfile(request);

        assertThat(response).isNotNull();
        assertThat(response.getResult()).isNotNull();

        DeviceProfileDetails result = response.getResult();

        assertThat(result.getName()).isEqualTo(testDeviceProfile.getName());
        assertThat(result.getClazz()).isEqualTo(testDeviceProfile.getClazz());
        assertThat(result.getSubclass()).isEqualTo(testDeviceProfile.getSubclass());
        assertThat(result.getVendor()).isEqualTo(testDeviceProfile.getVendor());
        assertThat(result.getProduct()).isEqualTo(testDeviceProfile.getProduct());
    }

    @Test(priority = 2)
    public void testGetDeviceProfileDetails() throws Exception {
        GetDeviceProfileDetailsRequest request = new GetDeviceProfileDetailsRequest(testDeviceProfile.getName());
        GetDeviceProfileDetailsResponse response = client.getDeviceProfileDetails(request);

        assertThat(response).isNotNull();
        assertThat(response.getResult()).isNotNull();

        DeviceProfileDetails result = response.getResult();

        assertThat(result.getName()).isEqualTo(testDeviceProfile.getName());
        assertThat(result.getClazz()).isEqualTo(testDeviceProfile.getClazz());
        assertThat(result.getSubclass()).isEqualTo(testDeviceProfile.getSubclass());
        assertThat(result.getVendor()).isEqualTo(testDeviceProfile.getVendor());
        assertThat(result.getProduct()).isEqualTo(testDeviceProfile.getProduct());
    }

    @Test(priority = 3)
    public void testGetAllDeviceProfileDetails() throws Exception {
        GetAllDeviceProfileDetailsRequest request = new GetAllDeviceProfileDetailsRequest();
        GetAllDeviceProfileDetailsResponse response = client.getAllDeviceProfileDetails(request);

        assertThat(response).isNotNull();
        assertThat(response.getResult()).isNotNull();

        DeviceProfileResultSet result = response.getResult();

        assertThat(result.getTotal()).isGreaterThan(0);
        assertThat(result.getItemCount()).isGreaterThan(0);
        assertThat(result.getResultSet()).isNotEmpty();
    }

    @Test(priority = 4)
    public void testUpdateDeviceProfile() throws Exception {
        String currentDeviceProfileName = testDeviceProfile.getName();

        testDeviceProfile.setName(TestUtils.createNewName("TEST-DVPRF"));
        testDeviceProfile.setClazz(TestUtils.createNewName("CLASS"));
        testDeviceProfile.setSubclass(TestUtils.createNewName("SUBCLASS"));
        testDeviceProfile.setVendor(TestUtils.createNewName("VENDOR"));
        testDeviceProfile.setProduct(TestUtils.createNewName("PRODUCT"));

        UpdateDeviceProfileRequest request = new UpdateDeviceProfileRequest(currentDeviceProfileName, testDeviceProfile);
        UpdateDeviceProfileResponse response = client.updateDeviceProfile(request);

        assertThat(response).isNotNull();
        assertThat(response.getResult()).isNotNull();

        DeviceProfileDetails result = response.getResult();

        assertThat(result.getName()).isEqualTo(testDeviceProfile.getName());
        assertThat(result.getClazz()).isEqualTo(testDeviceProfile.getClazz());
        assertThat(result.getSubclass()).isEqualTo(testDeviceProfile.getSubclass());
        assertThat(result.getVendor()).isEqualTo(testDeviceProfile.getVendor());
        assertThat(result.getProduct()).isEqualTo(testDeviceProfile.getProduct());
    }

    @Test(priority = 5)
    public void testDeleteDeviceProfile() throws Exception {
        DeleteDeviceProfileRequest request = new DeleteDeviceProfileRequest(testDeviceProfile.getName());
        DeleteDeviceProfileResponse response = client.deleteDeviceProfile(request);

        assertThat(response).isNotNull();
        assertThat(response.getResult()).isNotNull();

        Deleted result = response.getResult();

        assertThat(result.isDeleted()).isTrue();
    }
}