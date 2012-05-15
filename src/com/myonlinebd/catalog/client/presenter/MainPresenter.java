package com.myonlinebd.catalog.client.presenter;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.myonlinebd.catalog.client.view.HeaderView;

/**
 * author webmaster1803@gmail.com
 */
public class MainPresenter implements Activity {
    HeaderView mainView;

    public MainPresenter(HeaderView view) {
        mainView = view;
    }

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
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        mainView.addPresenter(this);
        panel.setWidget(mainView.asWidget());
    }
}
