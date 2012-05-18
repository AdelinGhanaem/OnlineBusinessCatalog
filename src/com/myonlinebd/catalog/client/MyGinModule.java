package com.myonlinebd.catalog.client;

import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.myonlinebd.catalog.client.presenter.AccountCreatorPresenter;
import com.myonlinebd.catalog.client.presenter.AccountCreatorPresenterImpl;
import com.myonlinebd.catalog.client.presenter.AppActivityMapper;
import com.myonlinebd.catalog.client.requestfactory.BusinessCardsRequestFactory;
import com.myonlinebd.catalog.client.view.AccountCreatorView;
import com.myonlinebd.catalog.client.view.AccountCreatorWorkflow;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class MyGinModule extends AbstractGinModule {
  @Override
  protected void configure() {

    bind(AccountCreatorView.class).to(AccountCreatorWorkflow.class).in(Singleton.class);

    bind(AccountCreatorPresenter.class).to(AccountCreatorPresenterImpl.class);


//    bind(new TypeLiteral<HashMap<String, Activity>>() {
//    }).annotatedWith(Names.named("activities")).toProvider(ActivitiesMapProvider.class).in(Singleton.class);

    bind(ActivityMapper.class).to(AppActivityMapper.class).in(Singleton.class);
  

    bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);

    bind(BusinessCardsRequestFactory.class).toProvider(BusinessCardsRequestFactoryProvider.class).in(Singleton.class);

    bind(PlaceController.class).to(InjectablePlaceController.class);


  }


  //TODO:Un able to bind the AccountCreatorView because of AddressEditor ... !
}
