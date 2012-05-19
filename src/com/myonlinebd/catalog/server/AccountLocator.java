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

  public AccountLocator() {
    service = new AccountServiceImpl(new InMemoryAccountRepository());
  }

  @Override
  public Account create(Class<? extends Account> clazz) {
    try {
      return clazz.newInstance();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Account find(Class<? extends Account> clazz, Long id) {
    return new Account();
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
