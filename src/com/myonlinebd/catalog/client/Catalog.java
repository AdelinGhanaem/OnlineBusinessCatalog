package com.myonlinebd.catalog.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.web.bindery.event.shared.EventBus;
import com.myonlinebd.catalog.client.place.HomePlace;
import com.myonlinebd.catalog.client.place.MainAppPlace;
import com.myonlinebd.catalog.client.presenter.AppActivityMapper;
import com.myonlinebd.catalog.client.view.HeaderView;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class Catalog implements EntryPoint {

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {

    MyGinInjector injector = GWT.create(MyGinInjector.class);

    SimpleLayoutPanel panel = new SimpleLayoutPanel();

    PlaceController placeController = injector.placeController();

    EventBus eventBus = injector.getEventBus();

    AppActivityMapper activityMapper = injector.activityMapper();

    ActivityManager manager = new ActivityManager(activityMapper, eventBus);

    manager.setDisplay(panel);

    ApplicationPlaceHistoryMapper placeHistoryMapper = GWT.create(ApplicationPlaceHistoryMapper.class);

    PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(placeHistoryMapper);

    historyHandler.register(placeController, eventBus, new MainAppPlace());

    HeaderView appView = new HeaderView(placeController);

    panel.add(appView);

    RootLayoutPanel.get().add(panel);

    placeController.goTo(new HomePlace());
  }
}
