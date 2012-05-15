package com.myonlinebd.catalog.client;

import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.web.bindery.event.shared.EventBus;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
@GinModules(MyGinModule.class)
public interface MyGinInjector extends Ginjector {


    ActivityMapper activityMapper();

    EventBus getEventBus();

//    AccountCreatorPresenter accountCreatorPresenter();

//    AccountCreatorPresenter getAccountCreatorPresenter();
}
