package com.connio.sdk.api.model;

import java.io.Serializable;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 19.09.2014
 */
public class Deleted implements Serializable {

    /**
     * TODO: javadoc
     */
    private boolean deleted;

    public Deleted() {
    }

    public Deleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Deleted deleted1 = (Deleted) o;

        if (deleted != deleted1.deleted) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (deleted ? 1 : 0);
    }

    @Override
    public String toString() {
        return "Deleted{" +
                "deleted=" + deleted +
                '}';
    }
}
