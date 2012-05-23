package com.myonlinebd.catalog.client.accountcreation.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.myonlinebd.catalog.shared.entities.AddressProxy;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class AddressEditor extends Composite implements Editor<AddressProxy> {


  @UiField
  TextBox postalCode;
  
  @UiField 
  TextBox town;

  @UiField
  TextBox street;


  interface AddressEditorBinder extends UiBinder<HTMLPanel, AddressEditor> {
  }

  AddressEditorBinder binder = GWT.create(AddressEditorBinder.class);


  public AddressEditor() {
    initWidget(binder.createAndBindUi(this));
  }
}
