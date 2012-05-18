package com.myonlinebd.catalog.shared.entities;

import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.ValueProxy;
import com.myonlinebd.catalog.server.domain.Response;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
@ProxyFor(value = Response.class)
public interface ResponseProxy extends ValueProxy {

  public String getResponseMessage();

  public void setResponseMessage(String responseMessage);


}
