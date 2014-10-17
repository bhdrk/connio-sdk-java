package com.connio.sdk.api.systemservices.users.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 11.09.2014
 */
public class UserDetails implements Serializable {

    /**
     * TODO: javadoc
     */
    private String sid;

    /**
     * TODO: javadoc
     */
    private String accountSid;

    /**
     * TODO: javadoc
     */
    private List<String> roles;

    /**
     * TODO: javadoc
     */
    private String uri;

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

    /**
     * TODO: javadoc
     */
    private Date dateCreated;

    /**
     * TODO: javadoc
     */
    private Date dateModified;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }
}
