package com.myonlinebd.catalog.server.domain;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class Account {

  private Long id;
  private String email;

  public Account() {
  }

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
