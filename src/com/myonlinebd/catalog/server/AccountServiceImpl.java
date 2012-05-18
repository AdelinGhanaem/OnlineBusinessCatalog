package com.myonlinebd.catalog.server;

import com.myonlinebd.catalog.server.domain.Account;
import com.myonlinebd.catalog.server.domain.Response;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class AccountServiceImpl implements AccountService {


  private AccountRepository repository;
  private ResponseFactory responseFactory;

  public AccountServiceImpl(AccountRepository accountRepository, ResponseFactory factory) {
    repository = accountRepository;
    responseFactory = factory;
  }


  public Account getAccountById(Long id) {
    return repository.getAccountById(id);
  }

  @Override
  public Response editAccount(Account account) {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public Response create(Account account) {
    System.out.println("account.getEmail(): " + account.getEmail());
    System.out.println("account.getPassword():" + account.getPassword());
    System.out.println("account.getAddress()"+ account.getAddress());
    return new Response();
  }

  //TODO:Eliminate The if else .... !

}
