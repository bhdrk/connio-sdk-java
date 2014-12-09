package com.connio.sdk.api.systemservices.accounts;

import com.connio.sdk.api.auth.ConnioCredentials;
import com.connio.sdk.api.auth.ConnioCredentialsManager;
import com.connio.sdk.api.model.Deleted;
import com.connio.sdk.api.systemservices.accounts.model.*;
import com.connio.sdk.api.systemservices.apps.model.AppResultSet;
import com.connio.sdk.api.systemservices.deviceprofiles.model.DeviceProfileResultSet;
import com.connio.sdk.api.systemservices.devices.model.DeviceResultSet;
import com.connio.sdk.api.systemservices.users.model.UserResultSet;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

import static com.connio.sdk.api.TestUtils.randomName;
import static org.fest.assertions.api.Assertions.assertThat;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 22.09.2014
 */
@Test(suiteName = "HttpTests", groups = "http")
public class AccountClientHttpTest {

    private IAccountClient client;

    private String testSubAccountSid;

    private SubAccount testSubAccount;

    @BeforeClass
    public void beforeClass() throws Exception {
        client = new AccountClient();

        testSubAccount = new SubAccount();
        testSubAccount.setDisplayName(randomName("TEST-ACCOUNT"));
        testSubAccount.setStatus(AccountStatusType.CREATED);
        //testSubAccount.setPlanType(PlanType.ENTERPRISE);
    }

    @Test
    public void testCreateSubAccount() throws Exception {
        SubAccountDetails result = client.createSubAccount(testSubAccount);

        assertThat(result).isNotNull();
        assertThat(result.getDisplayName()).isEqualTo(testSubAccount.getDisplayName());
        assertThat(result.getStatus()).isEqualTo(testSubAccount.getStatus());
        //assertThat(result.getPlanType()).isEqualTo(testSubAccount.getPlanType());

        testSubAccountSid = result.getSid();
    }

    @Test(dependsOnMethods = "testCreateSubAccount")
    public void testGetSubAccountDetails() throws Exception {
        SubAccountDetails result = client.getSubAccountDetails(testSubAccountSid);

        assertThat(result).isNotNull();
        assertThat(result.getDisplayName()).isEqualTo(testSubAccount.getDisplayName());
        assertThat(result.getStatus()).isEqualTo(testSubAccount.getStatus());
        //assertThat(result.getPlanType()).isEqualTo(testSubAccount.getPlanType());
    }

    // You can only regenerate your own account's authentication token.
    @Test(dependsOnMethods = "testCreateSubAccount", enabled = false)
    public void tesRegenerateAuthenticationToken() throws Exception {
        String currentAuthToken;
        {
            SubAccountDetails result = client.getSubAccountDetails(testSubAccountSid);

            assertThat(result).isNotNull();
            assertThat(result.getAuthToken()).isNotEmpty();
            assertThat(result.getAuthToken()).hasSize(32);

            currentAuthToken = result.getAuthToken();
        }
        {
            AuthToken result = client.regenerateAuthenticationToken(testSubAccountSid);

            assertThat(result).isNotNull();
            assertThat(result.getAuthToken()).isNotEmpty();
            assertThat(result.getAuthToken()).hasSize(32);
            assertThat(result.getAuthToken()).isNotEqualTo(currentAuthToken);
        }
    }

    @Test(dependsOnMethods = "testCreateSubAccount")
    public void testGetBillingInfo() throws Exception {
        BillingInfoList result = client.getBillingInfo(testSubAccountSid);

        assertThat(result).isNotNull();
        assertThat(result.getBillingInfo()).isNotEmpty();
    }

    @Test(dependsOnMethods = "testCreateSubAccount")
    public void testGetAllSubAccountDetails() throws Exception {
        SubAccountResultSet result = client.getAllSubAccountDetails();

        assertThat(result).isNotNull();
        assertThat(result.getItemCount()).isGreaterThan(0);
        assertThat(result.getTotal()).isGreaterThan(0);
        assertThat(result.getResultSet()).isNotEmpty();
    }

    @Test(dependsOnMethods = "testCreateSubAccount")
    public void testUpdateSubAccount() throws Exception {
        testSubAccount.setDisplayName("TEST-ACCOUNT-" + UUID.randomUUID().toString());
        testSubAccount.setStatus(AccountStatusType.ACTIVE);
        //testSubAccount.setPlanType(PlanType.SYSINT);

        SubAccountDetails result = client.updateSubAccount(testSubAccountSid, testSubAccount);

        assertThat(result).isNotNull();
        assertThat(result.getDisplayName()).isEqualTo(testSubAccount.getDisplayName());
        assertThat(result.getStatus()).isEqualTo(testSubAccount.getStatus());
        //assertThat(result.getPlanType()).isEqualTo(testSubAccount.getPlanType());
    }

    @Test(dependsOnMethods = "testUpdateSubAccount")
    public void testDeleteSubAccount() throws Exception {
        Deleted result = client.deleteSubAccount(testSubAccountSid);

        assertThat(result).isNotNull();
        assertThat(result.isDeleted()).isTrue();
    }

    @Test
    public void testGetMyAccountDetails() throws Exception {
        AccountDetails result = client.getMyAccountDetails();

        String accountSid = result.getSid();
        String currentAccountSid = ConnioCredentialsManager.getCredentials(ConnioCredentials.DEFAULT_PROFILE).getAccessKey();

        assertThat(accountSid).isEqualTo(currentAccountSid);
    }

    @Test
    public void testGetUsersOfAccount() throws Exception {
        final UserResultSet result = client.getUsersOfAccount("me");
        // just ensure that response is valid
        assertThat(result).isNotNull();
        assertThat(result.getTotal()).isGreaterThanOrEqualTo(0);
        assertThat(result.getItemCount()).isGreaterThanOrEqualTo(0);
        assertThat(result.getSkip()).isGreaterThanOrEqualTo(0);
        assertThat(result.getLimit()).isGreaterThanOrEqualTo(0);
        assertThat(result.getResultSet()).isNotNull();
    }

    @Test
    public void testGetAppsOfAccount() throws Exception {
        final AppResultSet result = client.getAppsOfAccount("me");
        // just ensure that response is valid
        assertThat(result).isNotNull();
        assertThat(result.getTotal()).isGreaterThanOrEqualTo(0);
        assertThat(result.getItemCount()).isGreaterThanOrEqualTo(0);
        assertThat(result.getSkip()).isGreaterThanOrEqualTo(0);
        assertThat(result.getLimit()).isGreaterThanOrEqualTo(0);
        assertThat(result.getResultSet()).isNotNull();
    }

    @Test
    public void testGetDevicesOfAccount() throws Exception {
        final DeviceResultSet result = client.getDevicesOfAccount("me");
        // just ensure that response is valid
        assertThat(result).isNotNull();
        assertThat(result.getTotal()).isGreaterThanOrEqualTo(0);
        assertThat(result.getItemCount()).isGreaterThanOrEqualTo(0);
        assertThat(result.getSkip()).isGreaterThanOrEqualTo(0);
        assertThat(result.getLimit()).isGreaterThanOrEqualTo(0);
        assertThat(result.getResultSet()).isNotNull();
    }

    @Test
    public void testGetDeviceProfilesOfAccount() throws Exception {
        final DeviceProfileResultSet result = client.getDeviceProfilesOfAccount("me");
        // just ensure that response is valid
        assertThat(result).isNotNull();
        assertThat(result.getTotal()).isGreaterThanOrEqualTo(0);
        assertThat(result.getItemCount()).isGreaterThanOrEqualTo(0);
        assertThat(result.getSkip()).isGreaterThanOrEqualTo(0);
        assertThat(result.getLimit()).isGreaterThanOrEqualTo(0);
        assertThat(result.getResultSet()).isNotNull();
    }
}
