package com.myonlinebd.catalog.client.view;

import com.google.gwt.user.client.ui.Widget;
import com.myonlinebd.catalog.client.presenter.AccountCreatorPresenter;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public interface AccountCreatorView {

    Widget asWidget();

    void setPresenter(AccountCreatorPresenter accountCreatorPresenter);

  void disableSubmitButton();
}
