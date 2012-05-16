package com.myonlinebd.catalog.server;

import com.myonlinebd.catalog.server.domain.Account;
import com.myonlinebd.catalog.server.domain.Response;

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
  public Response create(Account account) {
    List<String> errors = entityValidator.validate(account);

    if (errors.size() == 0) {
      repository.createAccount(account);
    }
    return new Response(errors);
  }
}
//TODO:Eliminate The if else .... !

