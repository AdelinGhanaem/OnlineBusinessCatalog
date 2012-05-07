package com.myonlinebd.catalog.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;
import com.myonlinebd.catalog.client.RequestFactory.BusinessCardsRequestFactory;
import com.myonlinebd.catalog.client.presenter.AccountCreatorPresenter;
import com.myonlinebd.catalog.client.presenter.AccountCreatorPresenterImpl;
import com.myonlinebd.catalog.client.view.AccountCreatorView;
import com.myonlinebd.catalog.client.view.AccountCreatorViewImpl;
import com.myonlinebd.catalog.shared.entities.ResponseProxy;

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

    AccountCreatorView view = new AccountCreatorViewImpl(new Receiver<ResponseProxy>() {
      @Override
      public void onFailure(ServerFailure error) {
        super.onFailure(error);
      }

      @Override
      public void onSuccess(ResponseProxy response) {
        Window.alert("OK!");
      }
    });

    AccountCreatorPresenter presenter = new AccountCreatorPresenterImpl(businessCardsRequestFactory, view);

    view.setPresenter(presenter);

    mainPanel.add(view.asWidget());


  }
}
