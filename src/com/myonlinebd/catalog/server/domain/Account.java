package com.myonlinebd.catalog.server.domain;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class Account {

  private Long id;
  private String email;
  private String password;
  private Address address=new Address();
  private String companyName;
  private String ownerName;
  private String activityType;


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

  public String getPassword() {
    return password;


  }

  public Address getAddress() {
    return address;
  }

  public String getCompanyName() {
    return companyName;
  }

  public String getOwnerName() {
    return ownerName;
  }

  public String getActivityType() {
    return activityType;
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

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public void setActivityType(String activityType) {
    this.activityType = activityType;
  }


}
