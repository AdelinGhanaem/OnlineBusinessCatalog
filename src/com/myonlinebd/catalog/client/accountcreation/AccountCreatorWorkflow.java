package com.myonlinebd.catalog.client.accountcreation;

import com.google.web.bindery.requestfactory.shared.Receiver;
import com.myonlinebd.catalog.client.comunication.BusinessCardsRequestFactory;
import com.myonlinebd.catalog.shared.entities.AccountProxy;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public interface AccountCreatorWorkflow {

  void createAccount(BusinessCardsRequestFactory.AccountContext context);

  void onEditing();

  AccountProxy getAccountProxy();

  void willCreate(AccountProxy proxy, Receiver<Void> receiver);

  BusinessCardsRequestFactory.AccountContext getAccountContext();
}
