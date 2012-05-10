package com.myonlinebd.catalog.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.web.bindery.event.shared.EventBus;
import com.myonlinebd.catalog.client.RequestFactory.BusinessCardsRequestFactory;
import com.myonlinebd.catalog.client.presenter.AccountCreatorPresenterImpl;
import com.myonlinebd.catalog.client.view.AccountCreatorWorkflow;


/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class Catalog implements EntryPoint {

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {


    HasWidgets mainPanel = RootPanel.get("right");
    BusinessCardsRequestFactory businessCardsRequestFactory = GWT.create(BusinessCardsRequestFactory.class);
    EventBus eventBus = new SimpleEventBus();
    businessCardsRequestFactory.initialize(eventBus);
    AccountCreatorWorkflow view = new AccountCreatorWorkflow(businessCardsRequestFactory, new AccountCreatorPresenterImpl(businessCardsRequestFactory));
    view.show(mainPanel);

  }
}
