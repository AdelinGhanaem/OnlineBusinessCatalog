package com.myonlinebd.catalog.client.requestfactory;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.RequestFactory;
import com.google.web.bindery.requestfactory.shared.Service;
import com.myonlinebd.catalog.server.AccountService;
import com.myonlinebd.catalog.server.MyServicesLocator;
import com.myonlinebd.catalog.shared.entities.AccountProxy;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public interface BusinessCardsRequestFactory extends RequestFactory {

  @Service(value = AccountService.class, locator = MyServicesLocator.class)
<<<<<<< HEAD

  public interface AccountContext extends RequestContext {
    public Request<Void> create(AccountProxy accountProxy);

=======
  public interface AccountContext extends RequestContext {

    public Request<Void> create(AccountProxy accountProxy);
>>>>>>> resolving conflicts

  }

  AccountContext accountContext();

<<<<<<< HEAD
}


=======

}
>>>>>>> resolving conflicts
