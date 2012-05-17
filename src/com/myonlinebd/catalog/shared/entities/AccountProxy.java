package com.myonlinebd.catalog.shared.entities;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.myonlinebd.catalog.server.AccountLocator;
import com.myonlinebd.catalog.server.domain.Account;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
@ProxyFor(value = Account.class, locator = AccountLocator.class)
public interface AccountProxy extends EntityProxy {

  public void setEmail(String email);

  public void setPassword(String password);

  public String getEmail();

  public String getPassword();

  public void setAddress(AddressProxy address);

  public void setCompany(CompanyProxy company);

  public AddressProxy getAddress();

  public CompanyProxy getCompany();


}
