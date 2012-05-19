package com.myonlinebd.catalog.client.presenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.myonlinebd.catalog.client.requestfactory.BusinessCardsRequestFactory;
import com.myonlinebd.catalog.client.view.AccountCreatorView;
import com.myonlinebd.catalog.shared.entities.AccountProxy;
import com.myonlinebd.catalog.shared.entities.AddressProxy;
import com.myonlinebd.catalog.shared.entities.CompanyProxy;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class AccountCreatorPresenterImpl extends AbstractActivity implements AccountCreatorPresenter {

    private AccountCreatorView view;
    private BusinessCardsRequestFactory.AccountContext accountRequestContext;


    @Inject
    public AccountCreatorPresenterImpl(AccountCreatorView view, BusinessCardsRequestFactory.AccountContext accountContext) {
        this.view = view;
        this.accountRequestContext = accountContext;
    }

    @Override
    public void createAccount(BusinessCardsRequestFactory.AccountContext context) {
        view.disableSubmitButton();
        context.fire();
    }

    @Override
    public void onEditing() {
        view.clearNotificationMessage();
    }

    @Override
    public AccountProxy getAccountProxy() {
        AccountProxy proxy = accountRequestContext.create(AccountProxy.class);
        AddressProxy addressProxy = accountRequestContext.create(AddressProxy.class);
        CompanyProxy companyProxy = accountRequestContext.create(CompanyProxy.class);
        proxy.setAddress(addressProxy);
        proxy.setCompany(companyProxy);
        return proxy;
    }

    @Override
    public void willCreate(AccountProxy proxy, Receiver<Void> receiver) {
        accountRequestContext.create(proxy).to(receiver);
    }

    @Override
    public BusinessCardsRequestFactory.AccountContext getAccountContext() {
        return accountRequestContext;
    }


    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        view.setPresenter(this);
        panel.setWidget(view.asWidget());
    }
}
