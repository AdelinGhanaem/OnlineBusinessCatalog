package com.myonlinebd.catalog.server.domain;

import javax.validation.constraints.NotNull;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class Account {


  private Long id;

  private String email;

  private String password;

  @NotNull
  private Address address = new Address();
  @NotNull
  private Company company;
//  private String companyName;
//  private String ownerName;
//  private String activityType;


  public Account() {
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


  public Company getCompany() {
    return company;
  }

  public Address getAddress() {
    return address;
  }


  public void setId(Long id) {
    this.id = id;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public void setCompany(Company company) {
    this.company = company;
  }


}
