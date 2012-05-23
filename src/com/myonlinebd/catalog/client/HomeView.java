package com.myonlinebd.catalog.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.inject.Inject;
import com.myonlinebd.catalog.client.navigation.HeaderView;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class HomeView extends Composite {

  private HomePresenter presenter;

  public void setPresenter(HomePresenter presenter) {
    this.presenter = presenter;
  }

  interface HomeViewUiBinder extends UiBinder<HTMLPanel, HomeView> {
  }

  private static HomeViewUiBinder ourUiBinder = GWT.create(HomeViewUiBinder.class);

  @UiField(provided = true)
  HeaderView header;

  @Inject
  public HomeView(HeaderView view) {
    header = view;
    initWidget(ourUiBinder.createAndBindUi(this));
  }


}