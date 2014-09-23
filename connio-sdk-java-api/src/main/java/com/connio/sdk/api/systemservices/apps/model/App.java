package com.connio.sdk.api.systemservices.apps.model;

import java.io.Serializable;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 22.09.2014
 */
public class App implements Serializable {

    /**
     * TODO: javadoc
     */
    private String name;

    /**
     * TODO: javadoc
     */
    private String displayName;

    /**
     * TODO: javadoc
     */
    private String description;

    /**
     * TODO: javadoc
     */
    private Long appStorageCapacity;

    /**
     * TODO: javadoc
     */
    private String version;

    /**
     * TODO: javadoc
     */
    private StateType state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAppStorageCapacity() {
        return appStorageCapacity;
    }

    public void setAppStorageCapacity(Long appStorageCapacity) {
        this.appStorageCapacity = appStorageCapacity;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public StateType getState() {
        return state;
    }

    public void setState(StateType state) {
        this.state = state;
    }
}
