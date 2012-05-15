package com.myonlinebd.catalog.client;

import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.myonlinebd.catalog.client.presenter.AccountCreatorPresenter;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
@GinModules(MyGinModule.class)
public interface MyGinInjector extends Ginjector {


  ActivityMapper activityMapper();


  PlaceController getPlaceController();


  EventBus getEventBus();

  AccountCreatorPresenter accountCreatorPresenter();

}
