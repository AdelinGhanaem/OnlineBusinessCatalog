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
import com.myonlinebd.catalog.client.RequestFactory.BusinessCardsRequestFactory;
import com.myonlinebd.catalog.client.place.AccountCreatorPlace;
import com.myonlinebd.catalog.client.place.MainAppPlace;
import com.myonlinebd.catalog.client.presenter.AppActivityMapper;
import com.myonlinebd.catalog.client.view.MainAppView;

import java.util.HashMap;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class Catalog implements EntryPoint {

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
//        MyGinInjector injector = GWT.create(MyGinInjector.class);

//    BusinessCardsRequestFactory businessCardsRequestFactory = GWT.create(BusinessCardsRequestFactory.class);
//    EventBus eventBus = new SimpleEventBus();
//    businessCardsRequestFactory.initialize(eventBus);
//    AccountCreatorPresenterImpl presenter = new AccountCreatorPresenterImpl(businessCardsRequestFactory, view);
//    view.setPresenter(presenter);
//    view.show(mainPanel);

        EventBus eventBus = new SimpleEventBus();

        MainAppView appView = new MainAppView();

        SimpleLayoutPanel panel = appView.getLayOutPanel();

        BusinessCardsRequestFactory businessCardsRequestFactory = GWT.create(BusinessCardsRequestFactory.class);

        businessCardsRequestFactory.initialize(eventBus);

        AppActivityMapper mapper = new AppActivityMapper(new HashMap<String, Activity>());

        ActivityManager manager = new ActivityManager(mapper, eventBus);

        manager.setDisplay(panel);

        PlaceController placeController = new PlaceController(eventBus);

        ApplicationPlaceHistoryMapper placeHistoryMapper = GWT.create(ApplicationPlaceHistoryMapper.class);

        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(placeHistoryMapper);

        historyHandler.register(placeController, eventBus, new MainAppPlace());

        RootLayoutPanel.get().add(panel);

        placeController.goTo(new AccountCreatorPlace());
    }
}
