package com.myonlinebd.catalog.client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.myonlinebd.catalog.client.place.MainAppPlace;
import com.myonlinebd.catalog.client.presenter.AppActivityMapper;
import com.myonlinebd.catalog.client.requestfactory.BusinessCardsRequestFactory;
import com.myonlinebd.catalog.client.view.HeaderView;

import java.util.HashMap;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class Catalog implements EntryPoint {

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {

    EventBus eventBus = new SimpleEventBus();


    SimpleLayoutPanel panel = new SimpleLayoutPanel();

    BusinessCardsRequestFactory businessCardsRequestFactory = GWT.create(BusinessCardsRequestFactory.class);

    businessCardsRequestFactory.initialize(eventBus);


    PlaceController placeController = new PlaceController(eventBus);


    AppActivityMapper mapper = new AppActivityMapper(new HashMap<String, Activity>(), placeController);

    ActivityManager manager = new ActivityManager(mapper, eventBus);

    manager.setDisplay(panel);

    ApplicationPlaceHistoryMapper placeHistoryMapper = GWT.create(ApplicationPlaceHistoryMapper.class);

    PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(placeHistoryMapper);

    historyHandler.register(placeController, eventBus, new MainAppPlace());

    HeaderView appView = new HeaderView(placeController);

    panel.add(appView);

    RootLayoutPanel.get().add(panel);

//        placeController.goTo(new AccountCreatorPlace());
  }
}
