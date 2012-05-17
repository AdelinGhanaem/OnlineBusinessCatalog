package com.myonlinebd.catalog.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class AccountCreatedSuccessfully {
  interface AccountCreatedSuccessfullyUiBinder extends UiBinder<DivElement, AccountCreatedSuccessfully> {
  }

  private static AccountCreatedSuccessfullyUiBinder ourUiBinder = GWT.create(AccountCreatedSuccessfullyUiBinder.class);

  public AccountCreatedSuccessfully() {
    DivElement rootElement = ourUiBinder.createAndBindUi(this);

  }
}