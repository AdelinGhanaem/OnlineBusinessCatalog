package com.myonlinebd.catalog.server;

import com.myonlinebd.catalog.server.model.Account;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public interface AccountRepository {
  Account getAccount(long id);

  void create(String accountEmail, String password);
}
