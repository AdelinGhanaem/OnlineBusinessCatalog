package com.myonlinebd.catalog.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.MenuItem;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class NavigationMenu extends Composite {
  interface NavigationMenuUiBinder extends UiBinder<HTMLPanel, NavigationMenu> {
  }

  private static NavigationMenuUiBinder ourUiBinder = GWT.create(NavigationMenuUiBinder.class);
  @UiField
  MenuItem Search;
  @UiField
  MenuItem newAccount;
  @UiField
  MenuItem aboutUs;

  public NavigationMenu() {
    HTMLPanel rootElement = ourUiBinder.createAndBindUi(this);
    initWidget(rootElement);
  }








}