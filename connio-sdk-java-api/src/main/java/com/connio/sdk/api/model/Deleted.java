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
}
