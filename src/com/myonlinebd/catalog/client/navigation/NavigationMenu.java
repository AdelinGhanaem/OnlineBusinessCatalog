package com.myonlinebd.catalog.client.navigation;

import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.inject.Inject;
import com.myonlinebd.catalog.client.navigation.places.AccountCreatorPlace;
import com.myonlinebd.catalog.client.navigation.places.HomePlace;

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
  @UiField
  MenuItem home;

  private PlaceController placeController;

  @Inject
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


    home.setCommand(new Command() {
      @Override
      public void execute() {
        placeController.goTo(new HomePlace());
      }
    });


  }


}