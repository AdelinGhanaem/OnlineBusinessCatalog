package com.myonlinebd.catalog.client.presenter;

import com.google.gwt.regexp.shared.RegExp;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.myonlinebd.catalog.client.RequestFactory.BusinessCardsRequestFactory;
import com.myonlinebd.catalog.client.view.AccountCreatorView;
import com.myonlinebd.catalog.shared.entities.AccountProxy;
import com.myonlinebd.catalog.shared.entities.ResponseProxy;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class AccountCreatorPresenterImpl implements AccountCreatorPresenter {

  private class Field {
  }

  private AccountCreatorView view;

  public AccountCreatorPresenterImpl(BusinessCardsRequestFactory requestFactory, AccountCreatorView creatorView) {
    view = creatorView;
  }


  @Override
  public void createAccount(BusinessCardsRequestFactory.AccountContext context, AccountProxy accountProxy, Receiver<ResponseProxy> receiver) {
    if (!isValidEmail(accountProxy.getEmail())) {
      view.invalidEmail();
    } else {
      if (!isValid(accountProxy.getPassword(),"^[a-zA-Z0-9]{6,}$")) {
        view.inValidPassword();
      } else {
        context.create(accountProxy).fire(receiver);
      }
    }
  }


  private boolean isValidEmail(String email) {
    return RegExp.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,6}$").test(email);

  }

  private boolean isValid(String field, String regex) {
    return RegExp.compile(regex).test(field);
  }



  //TODO:Eliminate the if else statement from the createAccountFunction !!!
  //TODO: DON'T FORGET TO READ ABOUT VALIDATION, AND HOW TO VALIDATE Editors fields
}
