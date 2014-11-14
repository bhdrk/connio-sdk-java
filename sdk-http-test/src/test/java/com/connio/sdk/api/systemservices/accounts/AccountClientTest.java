package com.connio.sdk.api.systemservices.accounts;

import com.connio.sdk.api.auth.ConnioCredentials;
import com.connio.sdk.api.AbstractClientMockServerTestCase;
import com.connio.sdk.api.model.Deleted;
import com.connio.sdk.api.systemservices.accounts.model.*;
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
 * @since 22.09.2014
 */
@Test(suiteName = "ClientTests")
public class AccountClientTest extends AbstractClientMockServerTestCase {

    private IAccountClient client;

    @BeforeClass
    public void beforeClass() throws Exception {
        client = new AccountClient(ConnioCredentials.DEFAULT_PROFILE, mockTransformer());
    }

    @Test
    public void testCreateSubAccount() throws Exception {
        final String expectedRequestJson = resource("json/systemservices/accounts/createSubAccount/request.json");
        final String mockResponseJson = resource("json/systemservices/accounts/createSubAccount/response.json");


        final Date date = parseStringToDate("2014-11-06T09:28:09.678Z");

        final SubAccount requestContent = new SubAccount();
        requestContent.setDisplayName("ATM.MANAGEMENT");
        requestContent.setPlanType(PlanType.ENTERPRISE);
        requestContent.setStatus(AccountStatusType.CREATED);

        final SubAccountDetails expectedResult = new SubAccountDetails();
        expectedResult.setSid("AC7035B09C6F274AB4B6FD41D43D65F1E2");
        expectedResult.setStatus(AccountStatusType.CREATED);
        expectedResult.setUri("/v1/_accounts/ac7035b09c6f274ab4b6fd41d43d65f1e2");
        expectedResult.setDevicesUri("/v1/_accounts/ac7035b09c6f274ab4b6fd41d43d65f1e2/_devices");
        expectedResult.setDeviceprofilesUri("/v1/_accounts/ac7035b09c6f274ab4b6fd41d43d65f1e2/_deviceprofiles");
        expectedResult.setAppsUri("/v1/_accounts/ac7035b09c6f274ab4b6fd41d43d65f1e2/_apps");
        expectedResult.setUsersUri("/v1/_accounts/ac7035b09c6f274ab4b6fd41d43d65f1e2/_users");
        expectedResult.setBillingInfoUri("/v1/_accounts/ac7035b09c6f274ab4b6fd41d43d65f1e2/_billinginfo");
        expectedResult.setAuthToken("00000000000000000000000000000000");
        expectedResult.setDisplayName("ATM.MANAGEMENT");
        expectedResult.setOwnerAccountSid("AC2BABAAA1DFBD4B70975B99856F54B612");
        expectedResult.setPlanType(PlanType.ENTERPRISE);
        expectedResult.setDateModified(date);
        expectedResult.setDateCreated(date);


        pushResponse(mockResponseJson);

        final SubAccountDetails result = client.createSubAccount(requestContent);

        assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("POST");
        assertThat(request.getPath()).isEqualTo("/v1/_accounts");
        assertThat(request.getBody()).isEqualTo(expectedRequestJson);
    }

    @Test
    public void testGetSubAccountDetails() throws Exception {
        final String mockResponseJson = resource("json/systemservices/accounts/getSubAccountDetails/response.json");


        final Date date = parseStringToDate("2014-11-06T09:28:09.678Z");

        final SubAccountDetails expectedResult = new SubAccountDetails();
        expectedResult.setSid("AC7035B09C6F274AB4B6FD41D43D65F1E2");
        expectedResult.setStatus(AccountStatusType.CREATED);
        expectedResult.setUri("/v1/_accounts/ac7035b09c6f274ab4b6fd41d43d65f1e2");
        expectedResult.setDevicesUri("/v1/_accounts/ac7035b09c6f274ab4b6fd41d43d65f1e2/_devices");
        expectedResult.setDeviceprofilesUri("/v1/_accounts/ac7035b09c6f274ab4b6fd41d43d65f1e2/_deviceprofiles");
        expectedResult.setAppsUri("/v1/_accounts/ac7035b09c6f274ab4b6fd41d43d65f1e2/_apps");
        expectedResult.setUsersUri("/v1/_accounts/ac7035b09c6f274ab4b6fd41d43d65f1e2/_users");
        expectedResult.setBillingInfoUri("/v1/_accounts/ac7035b09c6f274ab4b6fd41d43d65f1e2/_billinginfo");
        expectedResult.setAuthToken("00000000000000000000000000000000");
        expectedResult.setDisplayName("ATM.MANAGEMENT");
        expectedResult.setOwnerAccountSid("AC2BABAAA1DFBD4B70975B99856F54B612");
        expectedResult.setPlanType(PlanType.ENTERPRISE);
        expectedResult.setDateModified(date);
        expectedResult.setDateCreated(date);


        pushResponse(mockResponseJson);

        String sid = "AC7035B09C6F274AB4B6FD41D43D65F1E2";

        SubAccountDetails result = client.getSubAccountDetails(sid);

        assertThat(result).isEqualTo(expectedResult);

        Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("GET");
        assertThat(request.getPath()).isEqualTo("/v1/_accounts/" + sid);
        assertThat(request.getBody()).isNullOrEmpty();
    }

    @Test
    public void tesRegenerateAuthenticationToken() throws Exception {
        final String expectedRequestJson = resource("json/systemservices/accounts/regenerateAuthenticationToken/request.json");
        final String mockResponseJson = resource("json/systemservices/accounts/regenerateAuthenticationToken/response.json");


        final AuthToken expectedResult = new AuthToken();
        expectedResult.setAuthToken("00000000000000000000000000000000");


        pushResponse(mockResponseJson);

        String sid = "AC2BABAAA1DFBD4B70975B99856F54B612";

        AuthToken result = client.regenerateAuthenticationToken(sid);

        assertThat(result).isEqualTo(expectedResult);

        Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("POST");
        assertThat(request.getPath()).isEqualTo("/v1/_accounts/" + sid + "/_authtoken");
        assertThat(request.getBody()).isEqualTo(expectedRequestJson);
    }

    @Test
    public void testGetBillingInfo() throws Exception {
        final String mockResponseJson = resource("json/systemservices/accounts/getBillingInfo/response.json");


        final BillingInfo billingInfo1 = new BillingInfo();
        billingInfo1.setDate(1412592836638L);
        billingInfo1.setAmount(20L);

        final BillingInfo billingInfo2 = new BillingInfo();
        billingInfo2.setDate(1410000836638L);
        billingInfo2.setAmount(30L);

        final BillingInfo billingInfo3 = new BillingInfo();
        billingInfo3.setDate(1407322436638L);
        billingInfo3.setAmount(40L);

        final List<BillingInfo> billingInfoList = new ArrayList<BillingInfo>();

        billingInfoList.add(billingInfo1);
        billingInfoList.add(billingInfo2);
        billingInfoList.add(billingInfo3);

        final BillingInfoList expectedResult = new BillingInfoList();
        expectedResult.setBillingInfo(billingInfoList);


        pushResponse(mockResponseJson);

        final String sid = "AC2BABAAA1DFBD4B70975B99856F54B612";

        final BillingInfoList result = client.getBillingInfo(sid);

        assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("GET");
        assertThat(request.getPath()).isEqualTo("/v1/_accounts/" + sid + "/_billinginfo");
        assertThat(request.getBody()).isNullOrEmpty();
    }

    @Test
    public void testGetAllSubAccountDetails() throws Exception {
        final String mockResponseJson = resource("json/systemservices/accounts/getAllSubAccountDetails/response.json");


        final Date date1 = parseStringToDate("2014-11-06T09:28:09.678Z");
        final Date date2 = parseStringToDate("2014-11-06T12:07:17.584Z");
        final Date date3 = parseStringToDate("2014-11-06T15:41:10.605Z");

        final SubAccountDetails details1 = new SubAccountDetails();
        details1.setSid("AC7035B09C6F274AB4B6FD41D43D65F1E2");
        details1.setStatus(AccountStatusType.CREATED);
        details1.setUri("/v1/_accounts/ac7035b09c6f274ab4b6fd41d43d65f1e2");
        details1.setDevicesUri("/v1/_accounts/ac7035b09c6f274ab4b6fd41d43d65f1e2/_devices");
        details1.setDeviceprofilesUri("/v1/_accounts/ac7035b09c6f274ab4b6fd41d43d65f1e2/_deviceprofiles");
        details1.setAppsUri("/v1/_accounts/ac7035b09c6f274ab4b6fd41d43d65f1e2/_apps");
        details1.setUsersUri("/v1/_accounts/ac7035b09c6f274ab4b6fd41d43d65f1e2/_users");
        details1.setBillingInfoUri("/v1/_accounts/ac7035b09c6f274ab4b6fd41d43d65f1e2/_billinginfo");
        details1.setAuthToken("00000000000000000000000000000000");
        details1.setDisplayName("ATM.MANAGEMENT");
        details1.setOwnerAccountSid("AC2BABAAA1DFBD4B70975B99856F54B612");
        details1.setPlanType(PlanType.ENTERPRISE);
        details1.setDateModified(date1);
        details1.setDateCreated(date1);

        final SubAccountDetails details2 = new SubAccountDetails();
        details2.setSid("AC60C190FCD5214FFAA8131B2D6CFCF06C");
        details2.setStatus(AccountStatusType.CREATED);
        details2.setUri("/v1/_accounts/ac60c190fcd5214ffaa8131b2d6cfcf06c");
        details2.setDevicesUri("/v1/_accounts/ac60c190fcd5214ffaa8131b2d6cfcf06c/_devices");
        details2.setDeviceprofilesUri("/v1/_accounts/ac60c190fcd5214ffaa8131b2d6cfcf06c/_deviceprofiles");
        details2.setAppsUri("/v1/_accounts/ac60c190fcd5214ffaa8131b2d6cfcf06c/_apps");
        details2.setUsersUri("/v1/_accounts/ac60c190fcd5214ffaa8131b2d6cfcf06c/_users");
        details2.setBillingInfoUri("/v1/_accounts/ac60c190fcd5214ffaa8131b2d6cfcf06c/_billinginfo");
        details2.setAuthToken("00000000000000000000000000000000");
        details2.setDisplayName("COM.MANAGEMENT");
        details2.setOwnerAccountSid("AC2BABAAA1DFBD4B70975B99856F54B612");
        details2.setPlanType(PlanType.TRIAL);
        details2.setDateModified(date2);
        details2.setDateCreated(date2);

        final SubAccountDetails details3 = new SubAccountDetails();
        details3.setSid("ACDB2DDFD37C4545B9BB35D70C684B53D5");
        details3.setStatus(AccountStatusType.CREATED);
        details3.setUri("/v1/_accounts/acdb2ddfd37c4545b9bb35d70c684b53d5");
        details3.setDevicesUri("/v1/_accounts/acdb2ddfd37c4545b9bb35d70c684b53d5/_devices");
        details3.setDeviceprofilesUri("/v1/_accounts/acdb2ddfd37c4545b9bb35d70c684b53d5/_deviceprofiles");
        details3.setAppsUri("/v1/_accounts/acdb2ddfd37c4545b9bb35d70c684b53d5/_apps");
        details3.setUsersUri("/v1/_accounts/acdb2ddfd37c4545b9bb35d70c684b53d5/_users");
        details3.setBillingInfoUri("/v1/_accounts/acdb2ddfd37c4545b9bb35d70c684b53d5/_billinginfo");
        details3.setAuthToken("00000000000000000000000000000000");
        details3.setDisplayName("APS.MANAGEMENT");
        details3.setOwnerAccountSid("AC2BABAAA1DFBD4B70975B99856F54B612");
        details3.setPlanType(PlanType.TRIAL);
        details3.setDateModified(date3);
        details3.setDateCreated(date3);

        final List<SubAccountDetails> subAccountList = new ArrayList<SubAccountDetails>();
        subAccountList.add(details1);
        subAccountList.add(details2);
        subAccountList.add(details3);

        final SubAccountResultSet expectedResult = new SubAccountResultSet();
        expectedResult.setTotal(3);
        expectedResult.setItemCount(3);
        expectedResult.setSkip(0);
        expectedResult.setLimit(10);
        expectedResult.setResultSet(subAccountList);


        pushResponse(mockResponseJson);

        final SubAccountResultSet result = client.getAllSubAccountDetails();

        assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("GET");
        assertThat(request.getPath()).isEqualTo("/v1/_accounts");
        assertThat(request.getBody()).isNullOrEmpty();
    }

    @Test
    public void testUpdateSubAccount() throws Exception {
        final String expectedRequestJson = resource("json/systemservices/accounts/updateSubAccount/request.json");
        final String mockResponseJson = resource("json/systemservices/accounts/updateSubAccount/response.json");


        final Date date = parseStringToDate("2014-11-06T09:28:09.678Z");

        final SubAccount requestContent = new SubAccount();
        requestContent.setDisplayName("ATM.MANAGEMENT.V2");
        requestContent.setPlanType(PlanType.ENTERPRISE);
        requestContent.setStatus(AccountStatusType.ACTIVE);

        final SubAccountDetails expectedResult = new SubAccountDetails();
        expectedResult.setSid("AC7035B09C6F274AB4B6FD41D43D65F1E2");
        expectedResult.setStatus(AccountStatusType.ACTIVE);
        expectedResult.setUri("/v1/_accounts/ac7035b09c6f274ab4b6fd41d43d65f1e2");
        expectedResult.setDevicesUri("/v1/_accounts/ac7035b09c6f274ab4b6fd41d43d65f1e2/_devices");
        expectedResult.setDeviceprofilesUri("/v1/_accounts/ac7035b09c6f274ab4b6fd41d43d65f1e2/_deviceprofiles");
        expectedResult.setAppsUri("/v1/_accounts/ac7035b09c6f274ab4b6fd41d43d65f1e2/_apps");
        expectedResult.setUsersUri("/v1/_accounts/ac7035b09c6f274ab4b6fd41d43d65f1e2/_users");
        expectedResult.setBillingInfoUri("/v1/_accounts/ac7035b09c6f274ab4b6fd41d43d65f1e2/_billinginfo");
        expectedResult.setAuthToken("00000000000000000000000000000000");
        expectedResult.setDisplayName("ATM.MANAGEMENT.V2");
        expectedResult.setOwnerAccountSid("AC2BABAAA1DFBD4B70975B99856F54B612");
        expectedResult.setPlanType(PlanType.ENTERPRISE);
        expectedResult.setDateModified(date);
        expectedResult.setDateCreated(date);


        pushResponse(mockResponseJson);

        final String sid = "AC7035B09C6F274AB4B6FD41D43D65F1E2";

        final SubAccountDetails result = client.updateSubAccount(sid, requestContent);

        assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("PUT");
        assertThat(request.getPath()).isEqualTo("/v1/_accounts/" + sid);
        assertThat(request.getBody()).isEqualTo(expectedRequestJson);
    }


    @Test
    public void testDeleteSubAccount() throws Exception {
        final String mockResponseJson = resource("json/systemservices/accounts/deleteSubAccount/response.json");


        final Deleted expectedResult = new Deleted();
        expectedResult.setDeleted(true);


        pushResponse(mockResponseJson);

        final String sid = "AC07432219523B4978B4250FC39D1ACCE7";

        final Deleted result = client.deleteSubAccount(sid);

        assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("DELETE");
        assertThat(request.getPath()).isEqualTo("/v1/_accounts/" + sid);
        assertThat(request.getBody()).isNullOrEmpty();
    }

    @Test
    public void testGetMyAccountDetails() throws Exception {
        final String mockResponseJson = resource("json/systemservices/accounts/getMyAccountDetails/response.json");


        final Date date = parseStringToDate("2014-11-06T09:28:09.678Z");

        final AccountDetails expectedResult = new AccountDetails();
        expectedResult.setSid("AC2BABAAA1DFBD4B70975B99856F54B612");
        expectedResult.setStatus(AccountStatusType.CREATED);
        expectedResult.setUri("/v1/_accounts/me");
        expectedResult.setDevicesUri("/v1/_accounts/me/_devices");
        expectedResult.setDeviceprofilesUri("/v1/_accounts/me/_deviceprofiles");
        expectedResult.setAppsUri("/v1/_accounts/me/_apps");
        expectedResult.setUsersUri("/v1/_accounts/me/_users");
        expectedResult.setBillingInfoUri("/v1/_accounts/me/_billinginfo");
        expectedResult.setAuthToken("00000000000000000000000000000000");
        expectedResult.setDisplayName("MY.ACCOUNT");
        expectedResult.setPlanType(PlanType.ENTERPRISE);
        expectedResult.setDateModified(date);
        expectedResult.setDateCreated(date);


        pushResponse(mockResponseJson);

        final AccountDetails result = client.getMyAccountDetails();

        assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("GET");
        assertThat(request.getPath()).isEqualTo("/v1/_accounts/me");
        assertThat(request.getBody()).isNullOrEmpty();
    }
}
