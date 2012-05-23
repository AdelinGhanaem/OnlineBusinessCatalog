package com.myonlinebd.catalog.client.accountcreation.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.myonlinebd.catalog.shared.entities.AccountProxy;


/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class AccountEditor extends Composite implements Editor<AccountProxy> {

  interface AccountEditorUiBinder extends UiBinder<HTMLPanel, AccountEditor> {
  }

  AccountEditorUiBinder binder = GWT.create(AccountEditorUiBinder.class);

  @UiField
  public TextBox email;

  @UiField
  public PasswordTextBox password;

  @UiField
  public AddressEditor addressEditor;

  public AccountEditor() {
    initWidget(binder.createAndBindUi(this));
  }





}
