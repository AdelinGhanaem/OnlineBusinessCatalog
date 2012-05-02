package com.myonlinebd.catalog.server.model;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class Account {

  private Long id;
  private String email;

  public Account(Long id, String email) {
    this.id = id;
    this.email = email;
  }

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }
}
