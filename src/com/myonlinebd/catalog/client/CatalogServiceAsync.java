package com.myonlinebd.catalog.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CatalogServiceAsync {
  void getMessage(String msg, AsyncCallback<String> async);
}
