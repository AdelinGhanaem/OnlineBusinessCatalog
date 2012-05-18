package com.myonlinebd.catalog.client.presenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.myonlinebd.catalog.client.view.AccountSuccessfullyCreatedView;

/**
 * author webmaster1803@gmail.com
 */
public class AccountCreatedPresenter extends AbstractActivity {

    private AccountSuccessfullyCreatedView view;

    public AccountCreatedPresenter(AccountSuccessfullyCreatedView view) {
        this.view = view;
    }




    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        panel.setWidget(view);
    }
}
