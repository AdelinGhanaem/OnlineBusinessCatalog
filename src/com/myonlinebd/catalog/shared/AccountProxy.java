package com.myonlinebd.catalog.shared;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.myonlinebd.catalog.server.domain.Account;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
@ProxyFor(value = Account.class)
public interface AccountProxy extends EntityProxy {

  public Long getId();

  public String getEmail();

  public String setEmail(String email);

  public String setPassword(String password);



}
