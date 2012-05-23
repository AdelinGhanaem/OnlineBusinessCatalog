package com.myonlinebd.catalog.client.navigation;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.myonlinebd.catalog.client.HomePresenter;
import com.myonlinebd.catalog.client.accountcreation.AccountSuccefullyCreatedPresenter;
import com.myonlinebd.catalog.client.accountcreation.AccountCreatorWorkflowImpl;
import com.myonlinebd.catalog.client.accountcreation.view.FailurePagePresenter;
import com.myonlinebd.catalog.client.navigation.places.AccountCreatorPlace;
import com.myonlinebd.catalog.client.navigation.places.AccountSuccessfullyCreatedPlace;
import com.myonlinebd.catalog.client.navigation.places.FailurePagePlace;
import com.myonlinebd.catalog.client.navigation.places.HomePlace;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class AppActivityMapper implements ActivityMapper {


//  @Inject
//  AccountCreatorWorkflowView accountCreatorWorkFlowView;
//
//  @Inject
//  HomeView homeView;
//
//  @Inject
//  AccountSuccessfullyCreatedView view;
//
//  @Inject
//  BusinessCardsRequestFactory.AccountContext accountContext;
//
//  @Inject
//  FailurePage page;
//
//  @Inject
//  BusinessCardsRequestFactory factory;
//

  @Inject
  AccountCreatorWorkflowImpl accountCreatorWorkflow;

  @Inject
  HomePresenter homePresenter;

  @Inject
  AccountSuccefullyCreatedPresenter accountSuccefullyCreatedPresenter;

  @Inject
  FailurePagePresenter presenter;

  @Override
  public Activity getActivity(Place place) {
    //i don't like this at all ..... !!!!
    if (place instanceof AccountCreatorPlace) {
      return accountCreatorWorkflow;
    }
    if (place instanceof HomePlace) {
      return homePresenter;
    }
    if (place instanceof AccountSuccessfullyCreatedPlace) {
      return accountSuccefullyCreatedPresenter;
    }
    if (place instanceof FailurePagePlace) {
      return presenter;
    }
    return null;
  }
}
