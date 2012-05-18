package com.myonlinebd.catalog.client.presenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.myonlinebd.catalog.client.view.HomeView;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class HomePresenter extends AbstractActivity {

  @Inject
  HomeView view;

  public HomePresenter(HomeView place) {
    view = place;

  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    view.setPresenter(this);
    panel.setWidget(view);
  }


}
