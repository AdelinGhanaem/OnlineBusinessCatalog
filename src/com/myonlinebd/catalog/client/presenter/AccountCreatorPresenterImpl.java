package com.myonlinebd.catalog.client.presenter;

import com.google.web.bindery.requestfactory.shared.Receiver;
import com.myonlinebd.catalog.client.RequestFactory.BusinessCardsRequestFactory;
import com.myonlinebd.catalog.shared.entities.AccountProxy;
import com.myonlinebd.catalog.shared.entities.ResponseProxy;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class AccountCreatorPresenterImpl implements AccountCreatorPresenter {

  private final BusinessCardsRequestFactory factory;

  public AccountCreatorPresenterImpl(BusinessCardsRequestFactory requestFactory) {

    factory = requestFactory;
  }


  @Override
  public void createAccount(BusinessCardsRequestFactory.AccountContext context, AccountProxy accountProxy, Receiver<ResponseProxy> receiver) {
    context.create(accountProxy).fire(receiver);
  }


  //TODO:Eliminate the if else statement from the createAccountFunction !!!
  //TODO: DON'T FORGET TO READ ABOUT VALIDATION, AND HOW TO VALIDATE Editors fields
}
