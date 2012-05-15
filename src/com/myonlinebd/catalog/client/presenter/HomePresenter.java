package com.myonlinebd.catalog.client.presenter;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.myonlinebd.catalog.client.view.HomeView;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class HomePresenter implements Activity {

  @Inject
  HomeView view;

  public HomePresenter(HomeView place) {
    view = place;

  }



  @Override
  public String mayStop() {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public void onCancel() {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public void onStop() {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    view.setPresenter(this);
    panel.setWidget(view);
  }


}
