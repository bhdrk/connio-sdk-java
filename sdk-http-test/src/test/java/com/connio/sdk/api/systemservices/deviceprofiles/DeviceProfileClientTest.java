package com.connio.sdk.api.systemservices.deviceprofiles;

import com.connio.sdk.api.auth.ConnioCredentials;
import com.connio.sdk.api.AbstractClientMockServerTestCase;
import com.connio.sdk.api.model.Deleted;
import com.connio.sdk.api.systemservices.deviceprofiles.model.DeviceProfile;
import com.connio.sdk.api.systemservices.deviceprofiles.model.DeviceProfileDetails;
import com.connio.sdk.api.systemservices.deviceprofiles.model.DeviceProfileResultSet;
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
 *
 * @author bdirik
 * @since 25.09.2014
 */
@Test(suiteName = "ClientTests")
public class DeviceProfileClientTest extends AbstractClientMockServerTestCase {

    private IDeviceProfileClient client;

    @BeforeClass
    public void beforeClass() throws Exception {
        client = new DeviceProfileClient(ConnioCredentials.DEFAULT_PROFILE, mockTransformer());
    }

    @Test
    public void testCreateDeviceProfile() throws Exception {
        final String expectedRequestJson = resource("json/systemservices/deviceprofiles/createDeviceProfile/request.json");
        final String mockResponseJson = resource("json/systemservices/deviceprofiles/createDeviceProfile/response.json");


        final DeviceProfile requestContent = new DeviceProfile();
        requestContent.setName("TEST-DVPRF");
        requestContent.setClazz("CLASS");
        requestContent.setSubclass("SUBCLASS");
        requestContent.setVendor("VENDOR");
        requestContent.setProduct("PRODUCT");

        final Date date = parseStringToDate("2014-11-12T14:43:03.557Z");

        final DeviceProfileDetails expectedResult = new DeviceProfileDetails();
        expectedResult.setSid("0D51727C1C5D914A808106F2D024A6077B");
        expectedResult.setName("TEST-DVPRF");
        expectedResult.setUri("/v1/_deviceprofiles/test-dvprf");
        expectedResult.setClazz("CLASS");
        expectedResult.setSubclass("SUBCLASS");
        expectedResult.setVendor("VENDOR");
        expectedResult.setProduct("PRODUCT");
        expectedResult.setAccountSid("AC739E3716D10E47A89C6C972FF97B5852");
        expectedResult.setDateModified(date);
        expectedResult.setDateCreated(date);


        pushResponse(mockResponseJson);

        final DeviceProfileDetails result = client.createDeviceProfile(requestContent);

        assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("POST");
        assertThat(request.getPath()).isEqualTo("/v1/_deviceprofiles");
        assertThat(request.getBody()).isEqualTo(expectedRequestJson);
    }

    @Test
    public void testGetDeviceProfileDetails() throws Exception {
        final String mockResponseJson = resource("json/systemservices/deviceprofiles/getDeviceProfileDetails/response.json");


        final Date date = parseStringToDate("2014-11-12T14:43:03.557Z");

        final DeviceProfileDetails expectedResult = new DeviceProfileDetails();
        expectedResult.setSid("0D51727C1C5D914A808106F2D024A6077B");
        expectedResult.setName("TEST-DVPRF");
        expectedResult.setUri("/v1/_deviceprofiles/test-dvprf");
        expectedResult.setClazz("CLASS");
        expectedResult.setSubclass("SUBCLASS");
        expectedResult.setVendor("VENDOR");
        expectedResult.setProduct("PRODUCT");
        expectedResult.setAccountSid("AC739E3716D10E47A89C6C972FF97B5852");
        expectedResult.setDateModified(date);
        expectedResult.setDateCreated(date);


        pushResponse(mockResponseJson);

        final String profileName = "TEST-DVPRF";

        final DeviceProfileDetails result = client.getDeviceProfileDetails(profileName);

        assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("GET");
        assertThat(request.getPath()).isEqualTo("/v1/_deviceprofiles/" + profileName);
        assertThat(request.getBody()).isNullOrEmpty();
    }

    @Test
    public void testGetAllDeviceProfileDetails() throws Exception {
        final String mockResponseJson = resource("json/systemservices/deviceprofiles/getAllDeviceProfileDetails/response.json");


        final Date date1 = parseStringToDate("2014-09-25T14:49:41.007Z");

        final DeviceProfileDetails details1 = new DeviceProfileDetails();
        details1.setSid("0D375C2CFB674448208BBA61DCAEED3078");
        details1.setName("TEST-DVPRF-1");
        details1.setUri("/v1/_deviceprofiles/test-dvprf-1");
        details1.setClazz("ElectricMeter");
        details1.setSubclass("Smart");
        details1.setVendor("AcmeNextGen");
        details1.setProduct("X5500");
        details1.setAccountSid("AC739E3716D10E47A89C6C972FF97B5852");
        details1.setDateModified(date1);
        details1.setDateCreated(date1);


        final Date date2 = parseStringToDate("2014-09-25T09:41:08.518Z");

        final DeviceProfileDetails details2 = new DeviceProfileDetails();
        details2.setSid("0DAC571D2ECFFC4FB48A641051F4E86EFE");
        details2.setName("TEST-DVPRF-2");
        details2.setUri("/v1/_deviceprofiles/test-dvprf-2");
        details2.setClazz("ElectricMeter");
        details2.setSubclass("Smart");
        details2.setVendor("AcmeCo.");
        details2.setProduct("SM100");
        details2.setAccountSid("AC739E3716D10E47A89C6C972FF97B5852");
        details2.setDateModified(date2);
        details2.setDateCreated(date2);


        final Date date3 = parseStringToDate("2014-11-06T15:46:13.523Z");

        final DeviceProfileDetails details3 = new DeviceProfileDetails();
        details3.setSid("0D310F1A52384A4E9D956F4148EE99C6DC");
        details3.setName("TEST-DVPRF-3");
        details3.setUri("/v1/_deviceprofiles/test-dvprf-3");
        details3.setClazz("BANK");
        details3.setSubclass("ATM");
        details3.setVendor("NFC");
        details3.setProduct("XATM");
        details3.setAccountSid("AC739E3716D10E47A89C6C972FF97B5852");
        details3.setDateModified(date3);
        details3.setDateCreated(date3);

        final List<DeviceProfileDetails> profiles = new ArrayList<DeviceProfileDetails>();
        profiles.add(details1);
        profiles.add(details2);
        profiles.add(details3);

        final DeviceProfileResultSet expectedResult = new DeviceProfileResultSet();
        expectedResult.setTotal(3);
        expectedResult.setItemCount(3);
        expectedResult.setSkip(0);
        expectedResult.setLimit(10);
        expectedResult.setResultSet(profiles);


        pushResponse(mockResponseJson);

        final DeviceProfileResultSet result = client.getAllDeviceProfileDetails();

        assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("GET");
        assertThat(request.getPath()).isEqualTo("/v1/_deviceprofiles");
        assertThat(request.getBody()).isNullOrEmpty();
    }

    @Test
    public void testUpdateDeviceProfile() throws Exception {
        final String expectedRequestJson = resource("json/systemservices/deviceprofiles/updateDeviceProfile/request.json");
        final String mockResponseJson = resource("json/systemservices/deviceprofiles/updateDeviceProfile/response.json");


        final DeviceProfile requestContent = new DeviceProfile();
        requestContent.setName("TEST-DVPRF");
        requestContent.setClazz("CLASS");
        requestContent.setSubclass("SUBCLASS");
        requestContent.setVendor("VENDOR");
        requestContent.setProduct("PRODUCT");

        final Date date = parseStringToDate("2014-11-12T14:43:03.557Z");

        final DeviceProfileDetails expectedResult = new DeviceProfileDetails();
        expectedResult.setSid("0D51727C1C5D914A808106F2D024A6077B");
        expectedResult.setName("TEST-DVPRF");
        expectedResult.setUri("/v1/_deviceprofiles/test-dvprf");
        expectedResult.setClazz("CLASS");
        expectedResult.setSubclass("SUBCLASS");
        expectedResult.setVendor("VENDOR");
        expectedResult.setProduct("PRODUCT");
        expectedResult.setAccountSid("AC739E3716D10E47A89C6C972FF97B5852");
        expectedResult.setDateModified(date);
        expectedResult.setDateCreated(date);


        pushResponse(mockResponseJson);

        final String profileName = "TEST-DVPRF";

        final DeviceProfileDetails result = client.updateDeviceProfile(profileName, requestContent);

        assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("PUT");
        assertThat(request.getPath()).isEqualTo("/v1/_deviceprofiles/" + profileName);
        assertThat(request.getBody()).isEqualTo(expectedRequestJson);
    }

    @Test
    public void testDeleteDeviceProfile() throws Exception {
        final String mockResponseJson = resource("json/systemservices/deviceprofiles/deleteDeviceProfile/response.json");

        final Deleted expectedResult = new Deleted();
        expectedResult.setDeleted(true);

        pushResponse(mockResponseJson);

        final String profileName = "TEST-DVPRF";

        final Deleted result = client.deleteDeviceProfile(profileName);

        assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("DELETE");
        assertThat(request.getPath()).isEqualTo("/v1/_deviceprofiles/" + profileName);
        assertThat(request.getBody()).isNullOrEmpty();

    }
}