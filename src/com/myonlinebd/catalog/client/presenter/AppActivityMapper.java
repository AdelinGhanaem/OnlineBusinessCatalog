package com.myonlinebd.catalog.client.presenter;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.myonlinebd.catalog.client.place.AccountCreatorPlace;
import com.myonlinebd.catalog.client.place.AccountSuccessfullyCreatedPlace;
import com.myonlinebd.catalog.client.place.FailurePagePlace;
import com.myonlinebd.catalog.client.place.HomePlace;
import com.myonlinebd.catalog.client.requestfactory.BusinessCardsRequestFactory;
import com.myonlinebd.catalog.client.view.AccountCreatorView;
import com.myonlinebd.catalog.client.view.AccountSuccessfullyCreatedView;
import com.myonlinebd.catalog.client.view.FailurePage;
import com.myonlinebd.catalog.client.view.HomeView;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class AppActivityMapper implements ActivityMapper {


    @Inject
    AccountCreatorView accountCreatorWorkflow;

    @Inject
    HomeView homeView;

    @Inject
    AccountSuccessfullyCreatedView view;

    @Inject
    BusinessCardsRequestFactory.AccountContext accountContext;

    @Inject
    FailurePage page;

    @Override
    public Activity getActivity(Place place) {
        //i don't like this at all ..... !!!!

        if (place instanceof AccountCreatorPlace) {
            return new AccountCreatorPresenterImpl(accountCreatorWorkflow, accountContext);
        }
        if (place instanceof HomePlace) {
            return new HomePresenter(homeView);
        }

        if (place instanceof AccountSuccessfullyCreatedPlace) {
            return new AccountCreatedPresenter(view);
        }

        if (place instanceof FailurePagePlace) {
            return new FailurePagePresenter(page);
        }
        return null;
    }
}
