package com.myonlinebd.catalog.client;

import com.google.gwt.activity.shared.Activity;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.myonlinebd.catalog.client.place.AccountCreatorPlace;
import com.myonlinebd.catalog.client.presenter.AccountCreatorPresenter;

import java.util.HashMap;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class ActivitiesMapProvider implements Provider<HashMap<String, Activity>> {

  @Inject
  AccountCreatorPresenter accountCreatorPresenter;


  @Override
  public HashMap<String, Activity> get() {
    HashMap<String, Activity> map = new HashMap<String, Activity>();
    map.put(AccountCreatorPlace.class.toString(), accountCreatorPresenter);
    return map;
  }
}
