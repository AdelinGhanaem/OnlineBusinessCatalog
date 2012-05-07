package com.myonlinebd.catalog.client.RequestFactory;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.RequestFactory;
import com.google.web.bindery.requestfactory.shared.Service;
<<<<<<< HEAD
import com.myonlinebd.catalog.server.AccountService;
=======
import com.myonlinebd.catalog.server.AccountServiceImpl;
>>>>>>> 2c4d87e22d71a808b8c8ebc8c4fb8ab1963497b7
import com.myonlinebd.catalog.server.MyServicesLocator;
import com.myonlinebd.catalog.shared.entities.AccountProxy;
import com.myonlinebd.catalog.shared.entities.ResponseProxy;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public interface BusinessCardsRequestFactory extends RequestFactory {

  @Service(value = AccountService.class, locator = MyServicesLocator.class)
  public interface AccountContext extends RequestContext {

    public Request<ResponseProxy> create(String email, String password);

    public Request<AccountProxy> getAccountById(Long id);

    public Request<ResponseProxy> editAccount(AccountProxy accountProxy);
  }

  AccountContext accountContext();


}
