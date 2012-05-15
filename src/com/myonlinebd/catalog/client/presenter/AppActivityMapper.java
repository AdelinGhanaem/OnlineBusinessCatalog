package com.myonlinebd.catalog.client.presenter;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.myonlinebd.catalog.client.place.AccountCreatorPlace;
import com.myonlinebd.catalog.client.place.HomePlace;
import com.myonlinebd.catalog.client.view.AccountCreatorView;
import com.myonlinebd.catalog.client.view.HomeView;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class AppActivityMapper implements ActivityMapper {



  @Inject
  private PlaceController placeController;


  @Inject
  AccountCreatorView accountCreatorWorkflow;

  @Inject
  HomeView homeView;

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
}
