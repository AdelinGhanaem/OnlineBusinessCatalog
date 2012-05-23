package com.myonlinebd.catalog.client.accountcreation.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.inject.Inject;
import com.myonlinebd.catalog.client.navigation.HeaderView;

/**
 * author webmaster1803@gmail.com
 */
public class AccountSuccessfullyCreatedView extends Composite {

    interface AccountSuccessfullyCreatedUiBinder extends UiBinder<HTMLPanel, AccountSuccessfullyCreatedView> {
    }


    private static AccountSuccessfullyCreatedUiBinder ourUiBinder = GWT.create(AccountSuccessfullyCreatedUiBinder.class);

    @UiField(provided = true)
    HeaderView header;
    @Inject
    public AccountSuccessfullyCreatedView(HeaderView headerView) {
        header = headerView;
        HTMLPanel rootElement = ourUiBinder.createAndBindUi(this);
        initWidget(rootElement);
    }
}