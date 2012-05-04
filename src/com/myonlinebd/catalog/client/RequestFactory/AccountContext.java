package com.myonlinebd.catalog.client.RequestFactory;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.myonlinebd.catalog.server.AccountService;
import com.myonlinebd.catalog.server.MyServicesLocator;
import com.myonlinebd.catalog.shared.ResponseProxy;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */

@Service(value = AccountService.class, locator = MyServicesLocator.class)
public interface AccountContext extends RequestContext {
  Request<ResponseProxy> create(String email, String password);
}
