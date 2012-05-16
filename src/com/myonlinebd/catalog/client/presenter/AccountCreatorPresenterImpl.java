package com.myonlinebd.catalog.client.presenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.myonlinebd.catalog.client.requestfactory.BusinessCardsRequestFactory;
import com.myonlinebd.catalog.client.view.AccountCreatorView;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class AccountCreatorPresenterImpl implements AccountCreatorPresenter {

  private AccountCreatorView view;
  private RequestContext context;

  @Inject
  public AccountCreatorPresenterImpl(AccountCreatorView creatorView) {
    view = creatorView;
  }


  @Override
  public void createAccount(BusinessCardsRequestFactory.AccountContext context) {
    view.disableSubmitButton();
    context.fire();
  }

  @Override
  public void onAccountCreated() {

  }


  @Override
  public void onAccountValidationFailure(Set<ConstraintViolation<?>> violations) {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public void onConnectionFailure() {

  }


  public void setUp() {

  }


  //TODO:Eliminate the if else statement from the createAccountFunction !!!
  //TODO: DON'T FORGET TO READ ABOUT VALIDATION, AND HOW TO VALIDATE Editors fields

  @Override
  public String mayStop() {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public void onCancel() {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public void onStop() {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    view.setPresenter(this);
    panel.setWidget(view.asWidget());
  }
}
