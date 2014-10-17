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
    private AppStateType state;

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

    public AppStateType getState() {
        return state;
    }

    public void setState(AppStateType state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        App app = (App) o;

        if (appStorageCapacity != null ? !appStorageCapacity.equals(app.appStorageCapacity) : app.appStorageCapacity != null)
            return false;
        if (description != null ? !description.equals(app.description) : app.description != null) return false;
        if (displayName != null ? !displayName.equals(app.displayName) : app.displayName != null) return false;
        if (name != null ? !name.equals(app.name) : app.name != null) return false;
        if (state != app.state) return false;
        if (version != null ? !version.equals(app.version) : app.version != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (appStorageCapacity != null ? appStorageCapacity.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "App{" +
                "name='" + name + '\'' +
                ", displayName='" + displayName + '\'' +
                ", description='" + description + '\'' +
                ", appStorageCapacity=" + appStorageCapacity +
                ", version='" + version + '\'' +
                ", state=" + state +
                '}';
    }
}
