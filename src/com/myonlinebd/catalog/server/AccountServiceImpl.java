package com.myonlinebd.catalog.server;

import com.myonlinebd.catalog.server.domain.Account;
import com.myonlinebd.catalog.server.domain.Response;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

  public Response create(String email, String password) {
    if (password.length() >= 8) {
      if (isValidEmail(email)) {
        repository.create(email, password);
      } else {
        return responseFactory.invalidEmail();
      }
    } else {
      return responseFactory.shortPassword();
    }
    return responseFactory.accountCreated();
  }

  private boolean isValidEmail(String email) {
    Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$");
    Matcher matcher = pattern.matcher(email);
    return matcher.matches();
  }

  public Account getAccountById(Long  id) {
    return repository.getAccountById(id);
  }


  //TODO:Eliminate The if else .... !
}
