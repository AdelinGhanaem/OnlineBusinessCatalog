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

  private BusinessCardsRequestFactory requestFactory;
  private AccountCreatorView view;

  public AccountCreatorPresenterImpl(BusinessCardsRequestFactory requestFactory, AccountCreatorView accountCreatorView) {
    this.requestFactory = requestFactory;
    view = accountCreatorView;
  }


  @Override
  public void createAccount(String email, String password, Receiver<ResponseProxy> myReceiver) {
    if (emailIsValid(email)) {
      if (password.length() >= 8) {
        requestFactory.accountContext().create(email, password).fire(myReceiver);
      } else {
        view.notifyOfInvalidPassword();
      }
    } else {
      view.notifyOfInvalidEmail();
    }
  }

  @Override
  public void createAccount(AccountProxy accountProxy) {
    requestFactory.accountContext().create(accountProxy);
  }

  public boolean emailIsValid(String email) {
    RegExp regExp = RegExp.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$");
    return regExp.test(email);
  }
  //TODO:Eliminate the if else statement from the createAccountFunction !!!
  //TODO: DON'T FORGET TO READ ABOUT VALIDATION, AND HOW TO VALIDATE Editors fields
}
