package com.myonlinebd.catalog.server;

import com.google.web.bindery.requestfactory.shared.Locator;
import com.myonlinebd.catalog.server.domain.Response;

/**
 * author webmaster1803@gmail.com
 */
public class ResponseLocator extends Locator<Response, Long> {
    @Override
    public Response create(Class<? extends Response> clazz) {
        return new Response();
    }

    @Override
    public Response find(Class<? extends Response> clazz, Long id) {
        return new Response();
    }

    @Override
    public Class<Response> getDomainType() {
        return Response.class;
    }

    @Override
    public Long getId(Response domainObject) {
        return 1l;
    }

    @Override
    public Class<Long> getIdType() {
        return Long.class;
    }

    @Override
    public Object getVersion(Response domainObject) {
        return 1l;
    }
}
