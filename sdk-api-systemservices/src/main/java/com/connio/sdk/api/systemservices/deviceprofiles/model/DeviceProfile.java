package com.connio.sdk.api.systemservices.deviceprofiles.model;

import java.io.Serializable;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 25.09.2014
 */
public class DeviceProfile implements Serializable {

    /**
     * TODO: javadoc
     */
    private String name;

    /**
     * TODO: javadoc
     */
    private String description;

    /**
     * TODO: javadoc
     */
    private String clazz;

    /**
     * TODO: javadoc
     */
    private String subclass;

    /**
     * TODO: javadoc
     */
    private String vendor;

    /**
     * TODO: javadoc
     */
    private String product;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getSubclass() {
        return subclass;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeviceProfile that = (DeviceProfile) o;

        if (clazz != null ? !clazz.equals(that.clazz) : that.clazz != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (product != null ? !product.equals(that.product) : that.product != null) return false;
        if (subclass != null ? !subclass.equals(that.subclass) : that.subclass != null) return false;
        if (vendor != null ? !vendor.equals(that.vendor) : that.vendor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (clazz != null ? clazz.hashCode() : 0);
        result = 31 * result + (subclass != null ? subclass.hashCode() : 0);
        result = 31 * result + (vendor != null ? vendor.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DeviceProfile{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", clazz='" + clazz + '\'' +
                ", subclass='" + subclass + '\'' +
                ", vendor='" + vendor + '\'' +
                ", product='" + product + '\'' +
                '}';
    }
}
