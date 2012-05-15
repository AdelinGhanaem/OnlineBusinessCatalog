package com.myonlinebd.catalog;

import com.google.gwt.core.client.GWT;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;
import com.myonlinebd.catalog.client.RequestFactory.BusinessCardsRequestFactory;

/**
 * author webmaster1803@gmail.com
 */
public class BusinessCardsRequestFactoryProvider implements Provider<BusinessCardsRequestFactory> {

    @Inject
    EventBus eventBus;

    @Override
    public BusinessCardsRequestFactory get() {
        BusinessCardsRequestFactory factory = GWT.create(BusinessCardsRequestFactory.class);
        factory.initialize(eventBus);
        return factory;
    }
}
