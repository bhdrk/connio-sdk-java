package com.connio.sdk.api.systemservices.users;

import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.systemservices.users.model.User;
import com.connio.sdk.api.systemservices.users.model.UserDetails;
import com.connio.sdk.api.systemservices.users.model.UserResultSet;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 29.09.2014
 */
@Test(suiteName = "HttpTests")
public class UsersClientHttpTest {

    private UserClient client;

    private String testUserSid = "";

    @BeforeMethod
    public void beforeClass() throws Exception {
        client = new UserClient();
    }

    @Test(enabled = false)
    public void testGetUserDetails() throws Exception {
        UserDetails result = client.getUserDetails(testUserSid);

        assertThat(result).isNotNull();
        assertThat(result.getSid()).isEqualTo(testUserSid);
    }

    @Test(enabled = false)
    public void testGetAllUserDetails() throws Exception {
        UserResultSet result = client.getAllUserDetails();

        assertThat(result).isNotNull();
        assertThat(result.getItemCount()).isGreaterThan(0);
        assertThat(result.getTotal()).isGreaterThan(0);
        assertThat(result.getResultSet()).isNotEmpty();
    }

    @Test(expectedExceptions = ConnioClientException.class)
    public void testCreateUser() throws Exception {
        client.createUser(new User());
    }

    @Test(expectedExceptions = ConnioClientException.class)
    public void testUpdateUser() throws Exception {
        client.updateUser("", new User());
    }

    @Test(expectedExceptions = ConnioClientException.class)
    public void testDeleteUser() throws Exception {
        client.deleteUser("");
    }
}
