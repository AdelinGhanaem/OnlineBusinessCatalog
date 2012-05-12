package com.myonlinebd.catalog.client.presenter;

import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.myonlinebd.catalog.shared.entities.AccountProxy;
import com.myonlinebd.catalog.shared.entities.AddressProxy;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class TestAccountProxy implements AccountProxy {


  private String email;
  private String password;
  private AddressProxy address;
  private String ownerName;
  private String companyName;
  private String activityType;

  @Override
  public void setEmail(String email) {
    //To change body of implemented methods use File | Settings | File Templates.
    this.email = email;
  }

  @Override
  public void setPassword(String password) {
    //To change body of implemented methods use File | Settings | File Templates.
    this.password = password;
  }

  @Override
  public void setAddress(AddressProxy address) {
    //To change body of implemented methods use File | Settings | File Templates.
    this.address = address;
  }

  @Override
  public void setOwnerName(String ownerName) {
    //To change body of implemented methods use File | Settings | File Templates.
    this.ownerName = ownerName;
  }

  @Override
  public void setCompanyName(String companyName) {
    //To change body of implemented methods use File | Settings | File Templates.
    this.companyName = companyName;
  }

  @Override
  public void setActivityType(String activityType) {
    //To change body of implemented methods use File | Settings | File Templates.
    this.activityType = activityType;
  }

  @Override
  public String getEmail() {
    return email;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public EntityProxyId<?> stableId() {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  public AddressProxy getAddress() {
    return address;
  }

  public String getOwnerName() {
    return ownerName;
  }

  public String getCompanyName() {
    return companyName;
  }

  public String getActivityType() {
    return activityType;
  }
}
