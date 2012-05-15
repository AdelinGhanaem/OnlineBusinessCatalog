package com.myonlinebd.catalog.client.presenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.myonlinebd.catalog.client.RequestFactory.BusinessCardsRequestFactory;
import com.myonlinebd.catalog.client.view.AccountCreatorView;
import com.myonlinebd.catalog.shared.entities.AccountProxy;
import com.myonlinebd.catalog.shared.entities.ResponseProxy;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class AccountCreatorPresenterImpl implements AccountCreatorPresenter {

  private AccountCreatorView view;

  @Inject
  public AccountCreatorPresenterImpl( AccountCreatorView creatorView) {
    view = creatorView;
  }


  @Override
  public void createAccount(BusinessCardsRequestFactory.AccountContext context, AccountProxy accountProxy, Receiver<ResponseProxy> receiver) {
    context.create(accountProxy).fire(receiver);
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
