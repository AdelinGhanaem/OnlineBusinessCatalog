package com.myonlinebd.catalog.client.presenter;

import com.google.web.bindery.requestfactory.shared.Receiver;
import com.myonlinebd.catalog.client.requestfactory.BusinessCardsRequestFactory;
import com.myonlinebd.catalog.shared.entities.AccountProxy;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public interface AccountCreatorPresenter {

  void createAccount(BusinessCardsRequestFactory.AccountContext context);

  void onEditing();

  AccountProxy getAccountProxy();

  void willCreate(AccountProxy proxy, Receiver<Void> receiver);

  BusinessCardsRequestFactory.AccountContext getAccountContext();
}
