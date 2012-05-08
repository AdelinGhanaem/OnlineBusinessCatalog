package com.myonlinebd.catalog.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.ui.client.ValueBoxEditorDecorator;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.myonlinebd.catalog.shared.entities.AccountProxy;


/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class AccountEditor extends Composite implements Editor<AccountProxy> {

  interface AccountEditorUiBinder extends UiBinder<DecoratorPanel, AccountEditor> {

  }
  
  private  AccountEditorUiBinder binder = GWT.create(AccountEditorUiBinder.class);

  @UiField
  ValueBoxEditorDecorator<String> email;
  @UiField
  Button editButton;
  
  public AccountEditor() {
    initWidget(binder.createAndBindUi(this));
  }


  
}
