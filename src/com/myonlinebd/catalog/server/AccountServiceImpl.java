package com.myonlinebd.catalog.server;

import com.myonlinebd.catalog.server.domain.Account;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class AccountServiceImpl implements AccountService {


    private AccountRepository repository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        repository = accountRepository;
    }


//  public Account getAccountById(Long id) {
//    return repository.getAccountById(id);
//  }

    @Override
    public void create(Account account) {
        System.out.println("address" + account.getAddress());
        System.out.println("Company" + account.getCompany());
        System.out.println("Account" + account);
//        repository.createAccount(account);
    }
}
//TODO:Eliminate The if else .... !

