package com.connio.sdk.api.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 18.09.2014
 */
public class Sid {

    /**
     * TODO: javadoc
     */
    private String sid;

    public Sid(String sid) {
        this.sid = sid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sid sid1 = (Sid) o;

        if (sid != null ? !sid.equals(sid1.sid) : sid1.sid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return sid != null ? sid.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Sid{" +
                "sid='" + sid + '\'' +
                '}';
    }
}
