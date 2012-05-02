package com.myonlinebd.catalog.client.presenter;

import com.google.web.bindery.requestfactory.shared.Receiver;
import com.myonlinebd.catalog.shared.ResponseProxy;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public interface AccountCreatorPresenter {

  void createAccount(String email, String password, Receiver<ResponseProxy> myReceiver);

}
