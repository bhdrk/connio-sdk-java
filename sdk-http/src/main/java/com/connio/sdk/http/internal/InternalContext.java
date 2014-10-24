package com.connio.sdk.http.internal;

import com.connio.sdk.http.converter.ConverterChain;
import com.connio.sdk.http.utils.UserAgentInfo;

/**
 * Created by bdirik on 24.10.2014.
 */
public class InternalContext {

    private static final InternalContext instance = new InternalContext();

    private ClientConfigFactory clientConfigFactory;
    private RequestFactory requestFactory;
    private ResponseFactory responseFactory;
    private ConverterChain converterChain;
    private ClientFactory clientFactory;
    private UserAgentInfo userAgentInfo;

    private InternalContext() {
        this.clientConfigFactory = new ClientConfigFactory();
        this.requestFactory = new RequestFactory();
        this.responseFactory = new ResponseFactory();
        this.converterChain = new ConverterChain();
        this.clientFactory = new ClientFactory();
        this.userAgentInfo = new UserAgentInfo();
    }

    public static ClientConfigFactory clientConfigFactory() {
        return instance.clientConfigFactory;
    }

    public static RequestFactory requestFactory() {
        return instance.requestFactory;
    }

    public static ResponseFactory responseFactory() {
        return instance.responseFactory;
    }

    public static ConverterChain converterChain() {
        return instance.converterChain;
    }

    public static ClientFactory clientFactory() {
        return instance.clientFactory;
    }

    public static UserAgentInfo userAgentInfo() {
        return instance.userAgentInfo;
    }
}
