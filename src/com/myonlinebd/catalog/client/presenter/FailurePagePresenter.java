package com.myonlinebd.catalog.client.presenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.myonlinebd.catalog.client.view.FailurePage;

/**
 * author webmaster1803@gmail.com
 */
public class FailurePagePresenter extends AbstractActivity {

    private FailurePage page;

    @Inject
    public FailurePagePresenter(FailurePage page) {
        this.page = page;
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        panel.setWidget(page);
    }


}
