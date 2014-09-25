package com.connio.sdk.api.systemservices.datachannels.model;

import java.io.Serializable;
import java.util.Map;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public class AlarmAction implements Serializable {

    /**
     * TODO: javadoc
     */
    private AlarmActionName name;

    /**
     * TODO: javadoc
     */
    private Map<String, String> params;

    public AlarmActionName getName() {
        return name;
    }

    public void setName(AlarmActionName name) {
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

        AlarmAction that = (AlarmAction) o;

        if (name != that.name) return false;
        if (params != null ? !params.equals(that.params) : that.params != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (params != null ? params.hashCode() : 0);
        return result;
    }
}
