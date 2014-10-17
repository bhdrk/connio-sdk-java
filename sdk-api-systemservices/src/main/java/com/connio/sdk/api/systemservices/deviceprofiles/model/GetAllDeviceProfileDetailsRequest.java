package com.connio.sdk.api.systemservices.deviceprofiles.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.TypeUtils;

import static com.connio.sdk.api.model.Method.GET;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 25.09.2014
 */
public class GetAllDeviceProfileDetailsRequest extends DeviceProfileEndpointRequest<GetAllDeviceProfileDetailsResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        metaData.setMethod(GET);

        if (TypeUtils.isNotEmpty(clazz)) {
            metaData.addQueryParam("class", clazz);
        }
        if (TypeUtils.isNotEmpty(subclass)) {
            metaData.addQueryParam("subclass", subclass);
        }
        if (TypeUtils.isNotEmpty(vendor)) {
            metaData.addQueryParam("vendor", vendor);
        }
        if (TypeUtils.isNotEmpty(product)) {
            metaData.addQueryParam("product", product);
        }
    }

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

    public GetAllDeviceProfileDetailsRequest() {
    }

    public GetAllDeviceProfileDetailsRequest(String clazz, String subclass, String vendor, String product) {
        this.clazz = clazz;
        this.subclass = subclass;
        this.vendor = vendor;
        this.product = product;
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
}
