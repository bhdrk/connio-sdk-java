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
public class AccountEndpointClientImplHttpTest {

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
        CreateSubAccountRequest request = new CreateSubAccountRequest(testSubAccount);
        CreateSubAccountResponse response = client.createSubAccount(request);

        assertThat(response).isNotNull();
        assertThat(response.getResult()).isNotNull();

        SubAccountDetails result = response.getResult();

        assertThat(result.getDisplayName()).isEqualTo(testSubAccount.getDisplayName());
        assertThat(result.getStatus()).isEqualTo(testSubAccount.getStatus());
        //assertThat(result.getPlanType()).isEqualTo(testSubAccount.getPlanType());

        testSubAccountSid = result.getSid();
    }

    @Test(priority = 2)
    public void testGetSubAccountDetails() throws Exception {
        GetSubAccountDetailsRequest request = new GetSubAccountDetailsRequest(testSubAccountSid);
        GetSubAccountDetailsResponse response = client.getSubAccountDetails(request);

        assertThat(response).isNotNull();
        assertThat(response.getResult()).isNotNull();

        SubAccountDetails result = response.getResult();

        assertThat(result.getDisplayName()).isEqualTo(testSubAccount.getDisplayName());
        assertThat(result.getStatus()).isEqualTo(testSubAccount.getStatus());
        //assertThat(result.getPlanType()).isEqualTo(testSubAccount.getPlanType());
    }

    // You can only regenerate your own account's authentication token.
    @Test(priority = 3, enabled = false)
    public void tesCreateAuthenticationToken() throws Exception {
        String currentAuthToken;
        {
            GetSubAccountDetailsRequest request = new GetSubAccountDetailsRequest(testSubAccountSid);
            GetSubAccountDetailsResponse response = client.getSubAccountDetails(request);

            assertThat(response).isNotNull();
            assertThat(response.getResult()).isNotNull();

            SubAccountDetails result = response.getResult();
            assertThat(result.getAuthToken()).isNotEmpty();

            currentAuthToken = result.getAuthToken();
        }
        {
            CreateAuthenticationTokenRequest request = new CreateAuthenticationTokenRequest(testSubAccountSid);
            CreateAuthenticationTokenResponse response = client.createAuthenticationToken(request);

            assertThat(response).isNotNull();
            assertThat(response.getResult()).isNotNull();

            AuthToken result = response.getResult();
            String authToken = result.getAuthToken();

            assertThat(authToken).hasSize(32);
            assertThat(result.getAuthToken()).isNotEqualTo(currentAuthToken);
        }
    }

    @Test(priority = 4)
    public void testGetBillingInfo() throws Exception {
        GetBillingInfoRequest request = new GetBillingInfoRequest(testSubAccountSid);
        GetBillingInfoResponse response = client.getBillingInfo(request);

        assertThat(response).isNotNull();
        assertThat(response.getResult()).isNotNull();

        BillingInfoList result = response.getResult();

        assertThat(result.getBillingInfo()).isNotEmpty();
    }

    @Test(priority = 5)
    public void testGetAllSubAccountDetails() throws Exception {
        GetAllSubAccountsDetailsRequest request = new GetAllSubAccountsDetailsRequest();
        GetAllSubAccountsDetailsResponse response = client.getAllSubAccountDetails(request);

        assertThat(response).isNotNull();
        assertThat(response.getResult()).isNotNull();

        SubAccountResultSet result = response.getResult();

        assertThat(result.getItemCount()).isGreaterThan(0);
        assertThat(result.getTotal()).isGreaterThan(0);
        assertThat(result.getResultSet()).isNotEmpty();
    }

    @Test(priority = 6)
    public void testUpdateSubAccount() throws Exception {
        testSubAccount.setDisplayName("TEST-ACCOUNT-" + UUID.randomUUID().toString());
        testSubAccount.setStatus(StatusType.ACTIVE);
        //testSubAccount.setPlanType(PlanType.SYSINT);

        UpdateSubAccountRequest request = new UpdateSubAccountRequest(testSubAccountSid, testSubAccount);
        UpdateSubAccountResponse response = client.updateSubAccount(request);

        assertThat(response).isNotNull();
        assertThat(response.getResult()).isNotNull();

        SubAccountDetails result = response.getResult();

        assertThat(result.getDisplayName()).isEqualTo(testSubAccount.getDisplayName());
        assertThat(result.getStatus()).isEqualTo(testSubAccount.getStatus());
        //assertThat(result.getPlanType()).isEqualTo(testSubAccount.getPlanType());
    }

    @Test(priority = 7)
    public void testDeleteSubAccount() throws Exception {
        DeleteSubAccountRequest request = new DeleteSubAccountRequest(testSubAccountSid);
        DeleteSubAccountResponse response = client.deleteSubAccount(request);

        assertThat(response).isNotNull();
        assertThat(response.getResult()).isNotNull();

        Deleted result = response.getResult();

        assertThat(result.isDeleted()).isTrue();
    }

    @Test(priority = 8)
    public void testGetMyAccountDetails() throws Exception {
        GetMyAccountDetailsRequest request = new GetMyAccountDetailsRequest();

        GetMyAccountDetailsResponse response = client.getMyAccountDetails(request);
        AccountDetails result = response.getResult();

        String accountSid = result.getSid();
        String currentAccountSid = ConnioCredentialsManager.getCredentials().getAccessKey();

        assertThat(accountSid).isEqualTo(currentAccountSid);
    }
}
