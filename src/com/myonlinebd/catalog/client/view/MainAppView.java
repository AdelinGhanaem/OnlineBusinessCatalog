package com.myonlinebd.catalog.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class MainAppView extends Composite {

  interface MainAppViewUiBinder extends UiBinder<HTMLPanel, MainAppView> {
  }

  private static MainAppViewUiBinder ourUiBinder = GWT.create(MainAppViewUiBinder.class);
  @UiField
  NavigationMenu navMenu;


  public MainAppView() {
    HTMLPanel rootElement = ourUiBinder.createAndBindUi(this);
    initWidget(rootElement);
  }


  public void show(HasWidgets widgets) {
    widgets.clear();
    widgets.add(this);
  }

  @Override
  public Widget asWidget() {

    return this;
  }
}