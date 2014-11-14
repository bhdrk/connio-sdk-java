package com.connio.sdk.api.systemservices.apps.model;

import java.io.Serializable;
import java.util.Map;

/**
 * TODO: javadoc
 * <p/>
 * Created by bdirik on 14.11.2014.
 */
public class TriggerAction implements Serializable {

    private String name;

    private Map<String, String> params;

    public TriggerAction() {
    }

    public TriggerAction(String name, Map<String, String> params) {
        this.name = name;
        this.params = params;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TriggerAction that = (TriggerAction) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (params != null ? !params.equals(that.params) : that.params != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (params != null ? params.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TriggerAction{" +
                "name='" + name + '\'' +
                ", params=" + params +
                '}';
    }
}
