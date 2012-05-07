package com.myonlinebd.catalog.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
<<<<<<< HEAD
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
=======
import com.google.gwt.user.client.ui.*;
>>>>>>> 2c4d87e22d71a808b8c8ebc8c4fb8ab1963497b7
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.myonlinebd.catalog.client.presenter.AccountCreatorPresenter;
import com.myonlinebd.catalog.shared.entities.ResponseProxy;

/**
 * author webmaster1803@gmail.com
 */
@UiTemplate("AccountCreatorViewImpl.ui.xml")
public class AccountCreatorViewImpl extends Composite implements AccountCreatorView {

    private AccountCreatorPresenter presenter;


    interface AccountRegistrationBinder extends UiBinder<DecoratorPanel, AccountCreatorViewImpl> {
    }

    private Receiver<ResponseProxy> receiver;

    @UiField
    TextBox email;
    @UiField
    Label email_error;
    @UiField
    PasswordTextBox password;
    @UiField
    Label password_error;
    @UiField
    Button submit;

    private static AccountRegistrationBinder binder = GWT.create(AccountRegistrationBinder.class);


    public AccountCreatorViewImpl(Receiver<ResponseProxy> proxyReceiver) {
        initWidget(binder.createAndBindUi(this));
        receiver = proxyReceiver;
    }

     public void setPresenter(AccountCreatorPresenter accountCreatorPresenter) {
        presenter = accountCreatorPresenter;
    }



    @Override
    public void notifyOfInvalidEmail() {
        email_error.setText("Invalid email address.");

    }

    @Override
    public void notifyOfInvalidPassword() {
        password_error.setText("password must be 8 char long or more !");
    }

    public Widget asWidget() {
        return this;
    }


    @UiHandler("submit")
    public void onSubmit(ClickEvent event) {
        if (presenter != null && receiver != null) {
            presenter.createAccount(email.getText(), password.getText(), receiver);
        }
    }


}
