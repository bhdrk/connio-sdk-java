package com.connio.sdk.api.systemservices.users.model;

import java.io.Serializable;
import java.util.Date;
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
}
