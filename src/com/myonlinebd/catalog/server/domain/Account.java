package com.myonlinebd.catalog.server.domain;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class Account {


  private Long id;

  private String email;

  private String password;

  private Address address = new Address();

  private Company company;


  public Account() {
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {

    this.company = company;

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

}
