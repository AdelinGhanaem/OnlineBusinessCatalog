package com.myonlinebd.catalog.client.presenter;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public abstract  class AbstractActivity implements Activity{


  @Override
  public String mayStop() {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public void onCancel() {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public void onStop() {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public abstract void start(AcceptsOneWidget panel, EventBus eventBus);
}
