package com.myonlinebd.catalog.shared.entities;

import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.ValueProxy;
import com.myonlinebd.catalog.server.domain.Address;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
@ProxyFor(Address.class)
public interface AddressProxy extends ValueProxy {

  public void setPostalCode(String postalCode);

  public void setTown(String town);

  public void setStreet(String street);

  public String getStreet();
  
  public String getPostalCode();
  
  public String getTown();
  


}
