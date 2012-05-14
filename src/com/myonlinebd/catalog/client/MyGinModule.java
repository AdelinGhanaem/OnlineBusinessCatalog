package com.myonlinebd.catalog.client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.myonlinebd.catalog.client.presenter.AccountCreatorPresenter;
import com.myonlinebd.catalog.client.presenter.AccountCreatorPresenterImpl;
import com.myonlinebd.catalog.client.presenter.AppActivityMapper;

import java.util.HashMap;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class MyGinModule extends AbstractGinModule {
  @Override
  protected void configure() {

    bind(AccountCreatorPresenter.class).to(AccountCreatorPresenterImpl.class);

    bind(new TypeLiteral<HashMap<String, Activity>>() {

    }).annotatedWith(Names.named("activities")).toProvider(ActivitiesMapProvider.class);

    bind(EventBus.class).to(SimpleEventBus.class);

    bind(ActivityMapper.class).to(AppActivityMapper.class);


  }
}
