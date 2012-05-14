package com.myonlinebd.catalog.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.myonlinebd.catalog.ApplicationPlaceHistoryMapper;
import com.myonlinebd.catalog.client.place.AccountCreatorPlace;
import com.myonlinebd.catalog.client.view.MainAppView;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class Catalog implements EntryPoint {

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {


    HasWidgets mainPanel = RootPanel.get();
    MyGinInjector injector = GWT.create(MyGinInjector.class);

//    BusinessCardsRequestFactory businessCardsRequestFactory = GWT.create(BusinessCardsRequestFactory.class);
//    EventBus eventBus = new SimpleEventBus();
//    businessCardsRequestFactory.initialize(eventBus);
//    AccountCreatorWorkflow view = new AccountCreatorWorkflow(businessCardsRequestFactory);
//    AccountCreatorPresenterImpl presenter = new AccountCreatorPresenterImpl(businessCardsRequestFactory, view);
//    view.setPresenter(presenter);
//    view.show(mainPanel);

    MainAppView view = new MainAppView();

    SimplePanel panel = new SimplePanel();

    ActivityMapper mapper = injector.activityMapper();

    ActivityManager manager = new ActivityManager(mapper, injector.getEventBus());

    manager.setDisplay(panel);

    RootPanel.get().add(panel);

    ApplicationPlaceHistoryMapper placeHistoryMapper = GWT.create(ApplicationPlaceHistoryMapper.class);

    PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(placeHistoryMapper);

    historyHandler.register(injector.getPlaceController(), injector.getEventBus(), new AccountCreatorPlace());

    historyHandler.handleCurrentHistory();

  }
}
