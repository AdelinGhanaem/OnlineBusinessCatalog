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

    public Long getId();

    public void setId(Long id);

    public String getEmail();

    public void setEmail(String email);


}
