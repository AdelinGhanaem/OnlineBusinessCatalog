package com.myonlinebd.catalog.client;

import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.myonlinebd.catalog.client.accountcreation.AccountCreatorWorkflowView;
import com.myonlinebd.catalog.client.accountcreation.AccountCreatorWorkflowViewImpl;
import com.myonlinebd.catalog.client.comunication.BusinessCardsRequestFactory;
import com.myonlinebd.catalog.client.comunication.BusinessCardsRequestFactoryProvider;
import com.myonlinebd.catalog.client.navigation.AppActivityMapper;
import com.myonlinebd.catalog.client.navigation.InjectablePlaceController;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class MyGinModule extends AbstractGinModule {
  @Override
  protected void configure() {

    bind(AccountCreatorWorkflowView.class).to(AccountCreatorWorkflowViewImpl.class);

    bind(ActivityMapper.class).to(AppActivityMapper.class);

    bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);

    bind(BusinessCardsRequestFactory.class).toProvider(BusinessCardsRequestFactoryProvider.class);

    bind(PlaceController.class).to(InjectablePlaceController.class);


  }

  @Provides
  BusinessCardsRequestFactory.AccountContext getAccountContext(BusinessCardsRequestFactory factory) {
    BusinessCardsRequestFactory.AccountContext context = factory.accountContext();
    return context;
  }
}
