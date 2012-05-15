package com.myonlinebd.catalog.client.presenter;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.myonlinebd.catalog.client.requestfactory.BusinessCardsRequestFactory;
import com.myonlinebd.catalog.client.place.AccountCreatorPlace;
import com.myonlinebd.catalog.client.place.MainAppPlace;
import com.myonlinebd.catalog.client.view.AccountCreatorWorkflow;
import com.myonlinebd.catalog.client.view.HeaderView;

import java.util.HashMap;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class AppActivityMapper implements ActivityMapper {

  private HashMap<String, Activity> activityHashMap;

  private PlaceController placeController;

  @Inject
  public AppActivityMapper(@Named("activities") HashMap<String, Activity> map, PlaceController controller) {
    activityHashMap = map;
    placeController = controller;
  }


  @Override
  public Activity getActivity(Place place) {
    if (place instanceof MainAppPlace) {
      return new MainPresenter(new HeaderView(placeController));
    }
    if (place instanceof AccountCreatorPlace) {
      BusinessCardsRequestFactory factory = GWT.create(BusinessCardsRequestFactory.class);
      factory.initialize(new SimpleEventBus());
      return new AccountCreatorPresenterImpl(new AccountCreatorWorkflow(factory,placeController));
    }
    return null;
//    return activityHashMap.get(place.getClass().toString());
  }

  public void addActivity(String activityKey, Activity activity) {
    activityHashMap.put(activityKey, activity);
  }

  public void removeActivity(String newActivity) {
    activityHashMap.remove(newActivity);
  }
}
