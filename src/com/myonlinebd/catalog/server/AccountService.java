package com.myonlinebd.catalog.server;

import com.myonlinebd.catalog.server.domain.Account;
import com.myonlinebd.catalog.server.domain.Response;


/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */

public interface AccountService {

  Account getAccountById(Long id);

  public Response editAccount(Account account);

  public Response create(Account account);

}
