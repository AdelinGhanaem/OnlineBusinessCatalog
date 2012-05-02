package com.myonlinebd.catalog.client.RequestFactory;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.myonlinebd.catalog.shared.ResponseProxy;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */

public interface AccountContext extends RequestContext {

  Request<ResponseProxy> create(String email, String password);

}
