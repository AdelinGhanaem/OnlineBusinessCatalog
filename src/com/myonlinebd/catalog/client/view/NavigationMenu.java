package com.myonlinebd.catalog.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.MenuItem;
import com.myonlinebd.catalog.client.place.AccountCreatorPlace;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class NavigationMenu extends Composite {
  interface NavigationMenuUiBinder extends UiBinder<HTMLPanel, NavigationMenu> {
  }

  private static NavigationMenuUiBinder ourUiBinder = GWT.create(NavigationMenuUiBinder.class);
  @UiField
  MenuItem search;
  @UiField
  MenuItem newAccount;
  @UiField
  MenuItem aboutUs;

  private PlaceController placeController;

  public NavigationMenu(PlaceController controller) {
    HTMLPanel rootElement = ourUiBinder.createAndBindUi(this);
    placeController = controller;
    initWidget(rootElement);
    initMenu();
  }


  private void initMenu() {

    newAccount.setCommand(new Command() {
      @Override
      public void execute() {
        placeController.goTo(new AccountCreatorPlace());
      }
    });

    search.setCommand(new Command() {
      @Override
      public void execute() {
      }
    });

    aboutUs.setCommand(new Command() {
      @Override
      public void execute() {

      }
    });
  }


}