package com.myonlinebd.catalog.client.presenter;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import java.util.HashMap;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class AppActivityMapper implements ActivityMapper {

  private HashMap<String, Activity> activityHashMap;

  @Inject
  public AppActivityMapper(@Named("activities")HashMap<String, Activity> map) {
    activityHashMap = map;
  }

  @Override
  public Activity getActivity(Place place) {
    return activityHashMap.get(place.getClass().toString());
  }

  public void addActivity(String activityKey, Activity activity) {
    activityHashMap.put(activityKey, activity);
  }

  public void removeActivity(String newActivity) {
    activityHashMap.remove(newActivity);
  }
}
