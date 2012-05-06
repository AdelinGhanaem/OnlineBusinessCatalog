package com.myonlinebd.catalog.server;

import com.google.web.bindery.requestfactory.shared.Locator;
import com.myonlinebd.catalog.server.domain.Account;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class AccountLocator extends Locator<Account, Long> {


  private AccountService service;

  public AccountLocator(AccountService accountService) {
    service = accountService;
  }

  @Override
  public Account create(Class<? extends Account> clazz) {
    try {
        System.err.println("Some thing is wrong .... !");

      return clazz.newInstance();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
      System.err.println("Some thing is wrong .... ad23d23d23!");
    return null;
  }

  @Override
  public Account find(Class<? extends Account> clazz, Long id) {
    return service.getAccountById(id);
  }

  @Override
  public Class<Account> getDomainType() {
    return Account.class;
  }

  @Override
  public Long getId(Account domainObject) {
    return domainObject.getId();
  }

  @Override
  public Class<Long> getIdType() {
    return Long.class;
  }


  @Override
  public Object getVersion(Account domainObject) {
    return null;
  }


}
