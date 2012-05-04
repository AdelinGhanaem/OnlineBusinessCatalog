package com.myonlinebd.catalog.server;

import com.google.web.bindery.requestfactory.shared.ServiceLocator;
import com.myonlinebd.catalog.server.domain.Response;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class MyServicesLocator implements ServiceLocator {


  @Override
  public Object getInstance(Class<?> clazz) {
    return new AccountServiceImpl(new InMemoryAccountRepository(), new ResponseFactory() {
      @Override
      public Response invalidEmail() {
        return new Response("invalid email");
      }

      @Override
      public Response shortPassword() {
        return new Response("short password");
      }

      @Override
      public Response accountCreated() {
        return new Response("Every thing is OK !!");
      }
    });
  }
}
