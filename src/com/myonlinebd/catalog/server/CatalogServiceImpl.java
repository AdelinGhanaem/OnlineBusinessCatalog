package com.myonlinebd.catalog.catalog.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.myonlinebd.catalog.catalog.client.CatalogService;

public class CatalogServiceImpl extends RemoteServiceServlet implements CatalogService {
  // Implementation of sample interface method
  public String getMessage(String msg) {
    return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
  }
}