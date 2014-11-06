package com.connio.sdk.api.systemservices.accounts;

import com.connio.sdk.api.auth.ConnioCredentials;
import com.connio.sdk.api.core.AbstractClientMockServerTestCase;
import com.connio.sdk.api.model.Deleted;
import com.connio.sdk.api.systemservices.accounts.model.*;
import com.connio.sdk.http.json.JSON;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.connio.sdk.api.systemservices.TestUtils.resource;
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

        pushResponse(mockResponseJson);

        SubAccount subAccount = new SubAccount();
        subAccount.setDisplayName("TEST-ACCOUNT-1e00e03d-fe1b-4a34-9823-9643b6d4a3af");
        subAccount.setStatus(AccountStatusType.CREATED);

        SubAccountDetails result = client.createSubAccount(subAccount);
        SubAccountDetails expectedResult = JSON.fromString(mockResponseJson, SubAccountDetails.class);

        assertThat(result).isEqualTo(expectedResult);

        Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("POST");
        assertThat(request.getPath()).isEqualTo("/v1/_accounts");
        assertThat(request.getBody()).isEqualTo(expectedRequestJson);
    }

    @Test
    public void testGetSubAccountDetails() throws Exception {
        final String mockResponseJson = resource("json/systemservices/accounts/getSubAccountDetails/response.json");

        pushResponse(mockResponseJson);

        String sid = "AC2BABAAA1DFBD4B70975B99856F54B612";

        SubAccountDetails result = client.getSubAccountDetails(sid);
        SubAccountDetails expectedResult = JSON.fromString(mockResponseJson, SubAccountDetails.class);

        assertThat(result).isEqualTo(expectedResult);

        Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("GET");
        assertThat(request.getPath()).isEqualTo("/v1/_accounts/" + sid);
        assertThat(request.getBody()).isNullOrEmpty();
    }

    @Test
    public void tesCreateAuthenticationToken() throws Exception {
        final String expectedRequestJson = resource("json/systemservices/accounts/createAuthenticationToken/request.json");
        final String mockResponseJson = resource("json/systemservices/accounts/createAuthenticationToken/response.json");

        pushResponse(mockResponseJson);

        String sid = "AC2BABAAA1DFBD4B70975B99856F54B612";

        AuthToken result = client.createAuthenticationToken(sid);
        AuthToken expectedResult = JSON.fromString(mockResponseJson, AuthToken.class);

        assertThat(result).isEqualTo(expectedResult);

        Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("POST");
        assertThat(request.getPath()).isEqualTo("/v1/_accounts/" + sid + "/_authtoken");
        assertThat(request.getBody()).isEqualTo(expectedRequestJson);
    }

    @Test
    public void testGetBillingInfo() throws Exception {
        final String mockResponseJson = resource("json/systemservices/accounts/getBillingInfo/response.json");

        pushResponse(mockResponseJson);

        String sid = "AC2BABAAA1DFBD4B70975B99856F54B612";

        BillingInfoList result = client.getBillingInfo(sid);
        BillingInfoList expectedResult = JSON.fromString(mockResponseJson, BillingInfoList.class);

        assertThat(result).isEqualTo(expectedResult);

        Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("GET");
        assertThat(request.getPath()).isEqualTo("/v1/_accounts/" + sid + "/_billinginfo");
        assertThat(request.getBody()).isNullOrEmpty();
    }


    @Test
    public void testGetAllSubAccountDetails() throws Exception {
        final String mockResponseJson = resource("json/systemservices/accounts/getAllSubAccountDetails/response.json");

        pushResponse(mockResponseJson);

        SubAccountResultSet result = client.getAllSubAccountDetails();
        SubAccountResultSet expectedResult = JSON.fromString(mockResponseJson, SubAccountResultSet.class);

        assertThat(result).isEqualTo(expectedResult);

        Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("GET");
        assertThat(request.getPath()).isEqualTo("/v1/_accounts");
        assertThat(request.getBody()).isNullOrEmpty();
    }

    @Test
    public void testUpdateSubAccount() throws Exception {
        final String expectedRequestJson = resource("json/systemservices/accounts/updateSubAccount/request.json");
        final String mockResponseJson = resource("json/systemservices/accounts/updateSubAccount/response.json");

        pushResponse(mockResponseJson);

        SubAccount subAccount = new SubAccount();
        subAccount.setDisplayName("TEST-ACCOUNT-3e927351-c252-49c8-b3f1-17833882b542");
        subAccount.setStatus(AccountStatusType.ACTIVE);

        String sid = "AC07432219523B4978B4250FC39D1ACCE7";

        SubAccountDetails result = client.updateSubAccount(sid, subAccount);
        SubAccountDetails expectedResult = JSON.fromString(mockResponseJson, SubAccountDetails.class);

        assertThat(result).isEqualTo(expectedResult);

        Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("PUT");
        assertThat(request.getPath()).isEqualTo("/v1/_accounts/" + sid);
        assertThat(request.getBody()).isEqualTo(expectedRequestJson);
    }

    @Test
    public void testDeleteSubAccount() throws Exception {
        final String mockResponseJson = resource("json/systemservices/accounts/deleteSubAccount/response.json");

        pushResponse(mockResponseJson);

        String sid = "AC07432219523B4978B4250FC39D1ACCE7";

        Deleted result = client.deleteSubAccount(sid);
        Deleted expectedResult = JSON.fromString(mockResponseJson, Deleted.class);

        assertThat(result).isEqualTo(expectedResult);

        Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("DELETE");
        assertThat(request.getPath()).isEqualTo("/v1/_accounts/" + sid);
        assertThat(request.getBody()).isNullOrEmpty();
    }

    @Test
    public void testGetMyAccountDetails() throws Exception {
        final String mockResponseJson = resource("json/systemservices/accounts/getMyAccountDetails/response.json");

        pushResponse(mockResponseJson);

        AccountDetails result = client.getMyAccountDetails();
        AccountDetails expectedResult = JSON.fromString(mockResponseJson, AccountDetails.class);

        assertThat(result).isEqualTo(expectedResult);

        Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("GET");
        assertThat(request.getPath()).isEqualTo("/v1/_accounts/me");
        assertThat(request.getBody()).isNullOrEmpty();
    }
}
