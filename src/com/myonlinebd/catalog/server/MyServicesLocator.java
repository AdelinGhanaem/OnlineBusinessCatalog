package com.myonlinebd.catalog.server;

import com.google.web.bindery.requestfactory.shared.ServiceLocator;
import com.myonlinebd.catalog.server.domain.Response;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class MyServicesLocator implements ServiceLocator {

  AccountServiceImpl service = new AccountServiceImpl(new InMemoryAccountRepository(), new ResponseFactory() {
    @Override
    public Response invalidEmail() {
      return new Response();
    }

    @Override
    public Response shortPassword() {
      return new Response();
    }

    @Override
    public Response accountCreated() {
      return new Response();
    }
  });

  @Override
  public Object getInstance(Class<?> clazz) {

    return service;


  }
}
