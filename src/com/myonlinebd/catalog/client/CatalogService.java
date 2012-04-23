package com.myonlinebd.catalog.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("CatalogService")
public interface CatalogService extends RemoteService {
  // Sample interface method of remote interface
  String getMessage(String msg);

  /**
   * Utility/Convenience class.
   * Use CatalogService.App.getInstance() to access static instance of CatalogServiceAsync
   */
  public static class App {
    private static CatalogServiceAsync ourInstance = GWT.create(CatalogService.class);

    public static synchronized CatalogServiceAsync getInstance() {
      return ourInstance;
    }
  }
}
