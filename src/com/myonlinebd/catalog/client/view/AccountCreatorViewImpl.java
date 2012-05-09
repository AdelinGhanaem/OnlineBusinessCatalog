package com.myonlinebd.catalog.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.ui.client.ValueBoxEditorDecorator;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.myonlinebd.catalog.client.presenter.AccountCreatorPresenter;
import com.myonlinebd.catalog.shared.entities.AccountProxy;
import com.myonlinebd.catalog.shared.entities.ResponseProxy;

/**
 * author webmaster1803@gmail.com
 */
@UiTemplate("AccountCreatorViewImpl.ui.xml")
public class AccountCreatorViewImpl extends Composite implements AccountCreatorView, Editor<AccountProxy> {


  private AccountCreatorPresenter presenter;


  interface AccountRegistrationBinder extends UiBinder<HTMLPanel, AccountCreatorViewImpl> {
  }

  private Receiver<ResponseProxy> receiver;

  @UiField
  ValueBoxEditorDecorator<String> email;

  @UiField
  PasswordTextBox password;

  @UiField
  Button submit;

  private static AccountRegistrationBinder binder = GWT.create(AccountRegistrationBinder.class);


  public AccountCreatorViewImpl() {
    initWidget(binder.createAndBindUi(this));

  }

  public void setPresenter(AccountCreatorPresenter accountCreatorPresenter) {
    presenter = accountCreatorPresenter;
  }


  @Override
  public void notifyOfInvalidEmail() {

  }

  @Override
  public void notifyOfInvalidPassword() {

  }

  public Widget asWidget() {
    return this;
  }

}
