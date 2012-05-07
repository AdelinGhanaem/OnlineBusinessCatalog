package com.myonlinebd.catalog.server;

import com.myonlinebd.catalog.server.domain.Account;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class InMemoryAccountRepository implements AccountRepository {
  private Map<Long, InMemoryAccount> accountMap = new HashMap<Long, InMemoryAccount>();

  @Override
  public Account getAccountById(Long id) {
    InMemoryAccount inMemoryAccount = accountMap.get(id);
    return null;
  }

  @Override
  public void create(String accountEmail, String password) {
    Long selfGeneratingId = new Random().nextLong();
    accountMap.put(selfGeneratingId, new InMemoryAccount(selfGeneratingId, accountEmail, password));
    System.out.println("OK ......................!!");
    System.out.println(accountMap.get(selfGeneratingId));

  }


  private class InMemoryAccount {
    Long id;
    String email;
    String password;

    public InMemoryAccount(Long id, String email, String password) {
      this.id = id;
      this.email = email;
      this.password = password;
    }

    public Long getId() {
      return id;
    }

    public String getEmail() {
      return email;
    }

    public String getPassword() {
      return password;
    }
  }
}
