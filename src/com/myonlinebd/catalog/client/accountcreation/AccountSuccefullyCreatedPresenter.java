package com.myonlinebd.catalog.client.accountcreation;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.myonlinebd.catalog.client.navigation.AbstractActivity;
import com.myonlinebd.catalog.client.accountcreation.view.AccountSuccessfullyCreatedView;

/**
 * author webmaster1803@gmail.com
 */
public class AccountSuccefullyCreatedPresenter extends AbstractActivity {


  private AccountSuccessfullyCreatedView view;

  @Inject
  public AccountSuccefullyCreatedPresenter(AccountSuccessfullyCreatedView view) {
    this.view = view;
  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    panel.setWidget(view);
  }
}
