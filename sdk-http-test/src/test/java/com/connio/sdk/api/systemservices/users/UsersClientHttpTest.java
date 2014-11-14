package com.connio.sdk.api.systemservices.users;

import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.model.Deleted;
import com.connio.sdk.api.systemservices.users.model.User;
import com.connio.sdk.api.systemservices.users.model.UserDetails;
import com.connio.sdk.api.systemservices.users.model.UserResultSet;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.connio.sdk.api.TestUtils.randomName;
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

    private UserDetails testUser;

    @BeforeMethod
    public void beforeClass() throws Exception {
        client = new UserClient();
    }

    @Test
    public void testCreateUser() throws Exception {
        final String userName = randomName("user", false);
        final String email = userName + "@connio.com";

        final User user = new User();
        user.setDisplayName(userName);
        user.setEmail(email);
        user.setFullName(userName);
        user.setPassw("password");
        user.setRoles(Arrays.asList("user"));

        final UserDetails result = client.createUser(user);

        assertThat(result).isNotNull();
        assertThat(result.getFullName()).isEqualToIgnoringCase(user.getFullName());
        assertThat(result.getEmail()).isEqualToIgnoringCase(user.getEmail());
        assertThat(result.getDisplayName()).isEqualToIgnoringCase(user.getDisplayName());
        assertThat(result.getRoles()).isEqualTo(user.getRoles());
        assertThat(result.getAccountSid()).hasSize(34);
        assertThat(result.getSid()).hasSize(34);

        testUser = result;
    }

    @Test(dependsOnMethods = "testCreateUser")
    public void testGetUserDetails() throws Exception {
        UserDetails result = client.getUserDetails(testUser.getSid());

        assertThat(result).isNotNull();
        assertThat(result.getFullName()).isEqualToIgnoringCase(testUser.getFullName());
        assertThat(result.getEmail()).isEqualToIgnoringCase(testUser.getEmail());
        assertThat(result.getDisplayName()).isEqualToIgnoringCase(testUser.getDisplayName());
        assertThat(result.getRoles()).isEqualTo(testUser.getRoles());
        assertThat(result.getAccountSid()).isEqualTo(testUser.getAccountSid());
        assertThat(result.getSid()).isEqualTo(testUser.getSid());
        assertThat(result.getUri()).isEqualTo(testUser.getUri());
        assertThat(result.getDateCreated()).isEqualTo(testUser.getDateCreated());
        assertThat(result.getDateModified()).isEqualTo(testUser.getDateModified());
    }

    @Test(dependsOnMethods = "testCreateUser")
    public void testGetAllUserDetails() throws Exception {
        UserResultSet result = client.getAllUserDetails();

        assertThat(result).isNotNull();
        assertThat(result.getItemCount()).isGreaterThan(0);
        assertThat(result.getTotal()).isGreaterThan(0);
        assertThat(result.getResultSet()).isNotEmpty();
        assertThat(result.getResultSet()).contains(testUser);
    }

    @Test(dependsOnMethods = "testCreateUser")
    public void testUpdateUser() throws Exception {
        final String userName = randomName("USER");

        final User user = new User();
        user.setFullName(userName);

        final UserDetails result = client.updateUser(testUser.getSid(), user);

        assertThat(result.getFullName()).isEqualTo(userName);

        testUser = result;
    }

    @Test(dependsOnMethods = "testUpdateUser")
    public void testDeleteUser() throws Exception {
        final Deleted result = client.deleteUser(testUser.getSid());

        assertThat(result).isNotNull();
        assertThat(result.isDeleted()).isTrue();
    }
}
