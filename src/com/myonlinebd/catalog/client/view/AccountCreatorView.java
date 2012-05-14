package com.myonlinebd.catalog.client.view;

import com.myonlinebd.catalog.client.presenter.AccountCreatorPresenter;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public interface AccountCreatorView {

  void invalidEmail();


  void inValidPassword();

  void setPresenter(AccountCreatorPresenter accountCreatorPresenter);
}
