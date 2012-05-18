package com.myonlinebd.catalog.server;

import com.myonlinebd.catalog.server.domain.Account;

import java.util.List;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class AccountServiceImpl implements AccountService {


  private AccountRepository repository;

  private EntityValidator<Account> entityValidator;

  public AccountServiceImpl(AccountRepository accountRepository) {
    repository = accountRepository;
  }


//  public Account getAccountById(Long id) {
//    return repository.getAccountById(id);
//  }

  @Override
  public void create(Account account) {
      repository.createAccount(account);
  }
}
//TODO:Eliminate The if else .... !

