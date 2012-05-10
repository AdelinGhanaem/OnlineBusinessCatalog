package com.myonlinebd.catalog.server.domain;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class Address {


  private String town;
  private String postalCode;
  private String street;

  public String getPostalCode() {
    return postalCode;

  }

  public String getTown() {
    return town;
  }

  public String getStreet() {
    return street;
  }

  public void setTown(String town) {
    this.town = town;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public void setStreet(String street) {
    this.street = street;
  }

}
