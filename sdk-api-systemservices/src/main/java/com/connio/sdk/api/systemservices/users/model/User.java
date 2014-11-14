package com.connio.sdk.api.systemservices.users.model;

import java.io.Serializable;
import java.util.List;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 29.09.2014
 */
public class User implements Serializable {

    /**
     * TODO: javadoc
     */
    private List<String> roles;

    /**
     * TODO: javadoc
     */
    private String displayName;

    /**
     * TODO: javadoc
     */
    private String fullName;

    /**
     * TODO: javadoc
     */
    private String passw;

    /**
     * TODO: javadoc
     */
    private String email;

    /**
     * TODO: javadoc
     */
    private List<String> prefs;

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getPrefs() {
        return prefs;
    }

    public void setPrefs(List<String> prefs) {
        this.prefs = prefs;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (displayName != null ? !displayName.equals(user.displayName) : user.displayName != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (fullName != null ? !fullName.equals(user.fullName) : user.fullName != null) return false;
        if (passw != null ? !passw.equals(user.passw) : user.passw != null) return false;
        if (prefs != null ? !prefs.equals(user.prefs) : user.prefs != null) return false;
        if (roles != null ? !roles.equals(user.roles) : user.roles != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roles != null ? roles.hashCode() : 0;
        result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (passw != null ? passw.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (prefs != null ? prefs.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "roles=" + roles +
                ", displayName='" + displayName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", prefs=" + prefs +
                '}';
    }
}
