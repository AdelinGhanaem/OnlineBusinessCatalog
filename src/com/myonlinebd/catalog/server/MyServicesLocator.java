package com.myonlinebd.catalog.server;

import com.google.web.bindery.requestfactory.shared.ServiceLocator;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class MyServicesLocator implements ServiceLocator {

  AccountServiceImpl service = new AccountServiceImpl(new InMemoryAccountRepository());

  @Override
  public Object getInstance(Class<?> clazz) {

    return service;


  }
}
