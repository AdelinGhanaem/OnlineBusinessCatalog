package com.myonlinebd.catalog.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.myonlinebd.catalog.client.navigation.AbstractActivity;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class HomePresenter extends AbstractActivity {

  HomeView view;

  @Inject
  public HomePresenter(HomeView view) {
    this.view = view;
  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    view.setPresenter(this);
    panel.setWidget(view);
  }
}
