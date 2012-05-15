package com.myonlinebd.catalog.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.myonlinebd.catalog.client.presenter.MainPresenter;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class MainAppView extends Composite {
    private MainPresenter presenter;


    interface MainAppViewUiBinder extends UiBinder<HTMLPanel, MainAppView> {
    }

    private static MainAppViewUiBinder ourUiBinder = GWT.create(MainAppViewUiBinder.class);
    @UiField
    NavigationMenu navMenu;
    @UiField
    SimpleLayoutPanel mainPanel;


    public MainAppView() {
        HTMLPanel rootElement = ourUiBinder.createAndBindUi(this);
        initWidget(rootElement);
    }


    public void show(HasWidgets widgets) {
        widgets.clear();
        widgets.add(this);
    }

    @Override
    public Widget asWidget() {
        return this;
    }

    public void addPresenter(MainPresenter mainPresenter) {
        presenter = mainPresenter;
    }

    public SimpleLayoutPanel getLayOutPanel() {
        return mainPanel;
    }
}