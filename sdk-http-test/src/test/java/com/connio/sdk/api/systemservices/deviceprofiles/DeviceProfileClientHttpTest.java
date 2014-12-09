package com.connio.sdk.api.systemservices.deviceprofiles;

import com.connio.sdk.api.model.Deleted;
import com.connio.sdk.api.systemservices.deviceprofiles.model.DeviceProfile;
import com.connio.sdk.api.systemservices.deviceprofiles.model.DeviceProfileDetails;
import com.connio.sdk.api.systemservices.deviceprofiles.model.DeviceProfileResultSet;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.connio.sdk.api.TestUtils.randomName;
import static org.fest.assertions.api.Assertions.assertThat;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 25.09.2014
 */
@Test(suiteName = "HttpTests", groups = "http")
public class DeviceProfileClientHttpTest {

    private IDeviceProfileClient client;

    private DeviceProfile testDeviceProfile;

    @BeforeClass
    public void beforeClass() throws Exception {
        client = new DeviceProfileClient();
    }

    @Test
    public void testCreateDeviceProfile() throws Exception {
        testDeviceProfile = new DeviceProfile();
        testDeviceProfile.setName(randomName("TEST-DVPRF"));
        testDeviceProfile.setClazz(randomName("CLASS"));
        testDeviceProfile.setSubclass(randomName("SUBCLASS"));
        testDeviceProfile.setVendor(randomName("VENDOR"));
        testDeviceProfile.setProduct(randomName("PRODUCT"));

        DeviceProfileDetails result = client.createDeviceProfile(testDeviceProfile);

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(testDeviceProfile.getName());
        assertThat(result.getClazz()).isEqualTo(testDeviceProfile.getClazz());
        assertThat(result.getSubclass()).isEqualTo(testDeviceProfile.getSubclass());
        assertThat(result.getVendor()).isEqualTo(testDeviceProfile.getVendor());
        assertThat(result.getProduct()).isEqualTo(testDeviceProfile.getProduct());
    }

    @Test(dependsOnMethods = "testCreateDeviceProfile")
    public void testGetDeviceProfileDetails() throws Exception {
        DeviceProfileDetails result = client.getDeviceProfileDetails(testDeviceProfile.getName());

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(testDeviceProfile.getName());
        assertThat(result.getClazz()).isEqualTo(testDeviceProfile.getClazz());
        assertThat(result.getSubclass()).isEqualTo(testDeviceProfile.getSubclass());
        assertThat(result.getVendor()).isEqualTo(testDeviceProfile.getVendor());
        assertThat(result.getProduct()).isEqualTo(testDeviceProfile.getProduct());
    }

    @Test(dependsOnMethods = "testCreateDeviceProfile")
    public void testGetAllDeviceProfileDetails() throws Exception {
        DeviceProfileResultSet result = client.getAllDeviceProfileDetails();

        assertThat(result).isNotNull();
        assertThat(result.getTotal()).isGreaterThan(0);
        assertThat(result.getItemCount()).isGreaterThan(0);
        assertThat(result.getResultSet()).isNotEmpty();
    }

    @Test(dependsOnMethods = "testCreateDeviceProfile")
    public void testUpdateDeviceProfile() throws Exception {
        String currentDeviceProfileName = testDeviceProfile.getName();

        testDeviceProfile.setName(randomName("TEST-DVPRF"));
        testDeviceProfile.setClazz(randomName("CLASS"));
        testDeviceProfile.setSubclass(randomName("SUBCLASS"));
        testDeviceProfile.setVendor(randomName("VENDOR"));
        testDeviceProfile.setProduct(randomName("PRODUCT"));

        DeviceProfileDetails result = client.updateDeviceProfile(currentDeviceProfileName, testDeviceProfile);

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(testDeviceProfile.getName());
        assertThat(result.getClazz()).isEqualTo(testDeviceProfile.getClazz());
        assertThat(result.getSubclass()).isEqualTo(testDeviceProfile.getSubclass());
        assertThat(result.getVendor()).isEqualTo(testDeviceProfile.getVendor());
        assertThat(result.getProduct()).isEqualTo(testDeviceProfile.getProduct());
    }

    @Test(dependsOnMethods = "testUpdateDeviceProfile")
    public void testDeleteDeviceProfile() throws Exception {
        Deleted result = client.deleteDeviceProfile(testDeviceProfile.getName());

        assertThat(result).isNotNull();
        assertThat(result.isDeleted()).isTrue();
    }
}