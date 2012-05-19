package com.myonlinebd.catalog.client;

import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
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

        bind(AccountCreatorView.class).to(AccountCreatorWorkflow.class);

//        bind(AccountCreatorPresenter.class).to(AccountCreatorPresenterImpl.class);

        bind(ActivityMapper.class).to(AppActivityMapper.class);

        bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);

        bind(BusinessCardsRequestFactory.class).toProvider(BusinessCardsRequestFactoryProvider.class);

        bind(PlaceController.class).to(InjectablePlaceController.class);


    }

    @Provides
//    @Singleton
    BusinessCardsRequestFactory.AccountContext getAccountContext(BusinessCardsRequestFactory factory) {
        return factory.accountContext();
    }

}
