package com.connio.sdk.api.systemservices.accounts;

import com.connio.sdk.api.auth.ConnioCredentialsManager;
import com.connio.sdk.api.model.Deleted;
import com.connio.sdk.api.systemservices.accounts.model.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 22.09.2014
 */
@Test(groups = "httptest")
public class AccountEndpointClientHttpTest {

    private AccountEndpointClientImpl client;

    private String testSubAccountSid;

    private SubAccount testSubAccount;

    @BeforeClass
    public void beforeClass() throws Exception {
        client = new AccountEndpointClientImpl();

        testSubAccount = new SubAccount();
        testSubAccount.setDisplayName("TEST-ACCOUNT-" + UUID.randomUUID().toString());
        testSubAccount.setStatus(StatusType.CREATED);
        //testSubAccount.setPlanType(PlanType.ENTERPRISE);
    }

    @Test(priority = 1)
    public void testCreateSubAccount() throws Exception {
        SubAccountDetails result = client.createSubAccount(testSubAccount);

        assertThat(result).isNotNull();
        assertThat(result.getDisplayName()).isEqualTo(testSubAccount.getDisplayName());
        assertThat(result.getStatus()).isEqualTo(testSubAccount.getStatus());
        //assertThat(result.getPlanType()).isEqualTo(testSubAccount.getPlanType());

        testSubAccountSid = result.getSid();
    }

    @Test(priority = 2)
    public void testGetSubAccountDetails() throws Exception {
        SubAccountDetails result = client.getSubAccountDetails(testSubAccountSid);

        assertThat(result).isNotNull();
        assertThat(result.getDisplayName()).isEqualTo(testSubAccount.getDisplayName());
        assertThat(result.getStatus()).isEqualTo(testSubAccount.getStatus());
        //assertThat(result.getPlanType()).isEqualTo(testSubAccount.getPlanType());
    }

    // You can only regenerate your own account's authentication token.
    @Test(priority = 3, enabled = false)
    public void tesCreateAuthenticationToken() throws Exception {
        String currentAuthToken;
        {
            SubAccountDetails result = client.getSubAccountDetails(testSubAccountSid);

            assertThat(result).isNotNull();
            assertThat(result.getAuthToken()).isNotEmpty();
            assertThat(result.getAuthToken()).hasSize(32);

            currentAuthToken = result.getAuthToken();
        }
        {
            AuthToken result = client.createAuthenticationToken(testSubAccountSid);

            assertThat(result).isNotNull();
            assertThat(result.getAuthToken()).isNotEmpty();
            assertThat(result.getAuthToken()).hasSize(32);
            assertThat(result.getAuthToken()).isNotEqualTo(currentAuthToken);
        }
    }

    @Test(priority = 4)
    public void testGetBillingInfo() throws Exception {
        BillingInfoList result = client.getBillingInfo(testSubAccountSid);

        assertThat(result).isNotNull();
        assertThat(result.getBillingInfo()).isNotEmpty();
    }

    @Test(priority = 5)
    public void testGetAllSubAccountDetails() throws Exception {
        SubAccountResultSet result = client.getAllSubAccountDetails();

        assertThat(result).isNotNull();
        assertThat(result.getItemCount()).isGreaterThan(0);
        assertThat(result.getTotal()).isGreaterThan(0);
        assertThat(result.getResultSet()).isNotEmpty();
    }

    @Test(priority = 6)
    public void testUpdateSubAccount() throws Exception {
        testSubAccount.setDisplayName("TEST-ACCOUNT-" + UUID.randomUUID().toString());
        testSubAccount.setStatus(StatusType.ACTIVE);
        //testSubAccount.setPlanType(PlanType.SYSINT);

        SubAccountDetails result = client.updateSubAccount(testSubAccountSid, testSubAccount);

        assertThat(result).isNotNull();
        assertThat(result.getDisplayName()).isEqualTo(testSubAccount.getDisplayName());
        assertThat(result.getStatus()).isEqualTo(testSubAccount.getStatus());
        //assertThat(result.getPlanType()).isEqualTo(testSubAccount.getPlanType());
    }

    @Test(priority = 7)
    public void testDeleteSubAccount() throws Exception {
        Deleted result = client.deleteSubAccount(testSubAccountSid);

        assertThat(result).isNotNull();
        assertThat(result.isDeleted()).isTrue();
    }

    @Test(priority = 8)
    public void testGetMyAccountDetails() throws Exception {
        AccountDetails result = client.getMyAccountDetails();

        String accountSid = result.getSid();
        String currentAccountSid = ConnioCredentialsManager.getCredentials().getAccessKey();

        assertThat(accountSid).isEqualTo(currentAccountSid);
    }
}
