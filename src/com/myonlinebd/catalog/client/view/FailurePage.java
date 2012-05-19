package com.myonlinebd.catalog.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.inject.Inject;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class FailurePage extends Composite {

    interface FailurePageUiBinder extends UiBinder<HTMLPanel, FailurePage> {
    }

    private static FailurePageUiBinder ourUiBinder = GWT.create(FailurePageUiBinder.class);

    @UiField(provided = true)
    HeaderView header;
    @Inject
    public FailurePage(HeaderView headerView) {
        header = headerView;
        HTMLPanel rootElement = ourUiBinder.createAndBindUi(this);
        initWidget(rootElement);
    }
}