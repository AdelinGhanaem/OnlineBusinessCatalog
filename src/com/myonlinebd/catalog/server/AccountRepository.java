package com.myonlinebd.catalog.server;

import com.myonlinebd.catalog.server.domain.Account;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public interface AccountRepository {

  Account getAccountById(Long email);

  void create(String accountEmail, String password);

}