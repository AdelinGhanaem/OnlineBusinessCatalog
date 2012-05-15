package com.myonlinebd.catalog.client.presenter;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.myonlinebd.catalog.client.MyGinInjector;
import com.myonlinebd.catalog.client.place.AccountCreatorPlace;
import com.myonlinebd.catalog.client.place.HomePlace;
import com.myonlinebd.catalog.client.view.AccountCreatorView;
import com.myonlinebd.catalog.client.view.HomeView;

import java.util.HashMap;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class AppActivityMapper implements ActivityMapper {

  @Inject
  private HashMap<String, Activity> activityHashMap;

  @Inject
  private PlaceController placeController;


  @Inject
  AccountCreatorView accountCreatorWorkflow;

  @Inject
  HomeView homeView;


//  public AppActivityMapper(@Named("activities") HashMap<String, Activity> map, PlaceController controller) {
//    activityHashMap = map;
//    placeController = controller;
//  }

  private MyGinInjector ginInjector;

//  @Inject
//  public AppActivityMapper(MyGinInjector injector) {
//    ginInjector = injector;
//  }

  @Override
  public Activity getActivity(Place place) {
    if (place instanceof AccountCreatorPlace) {
      return new AccountCreatorPresenterImpl(accountCreatorWorkflow);
    }
    if (place instanceof HomePlace) {
      return new HomePresenter(homeView);
    }
    return null;
  }

  public void addActivity(String activityKey, Activity activity) {
    activityHashMap.put(activityKey, activity);
  }

  public void removeActivity(String newActivity) {
    activityHashMap.remove(newActivity);
  }
}
