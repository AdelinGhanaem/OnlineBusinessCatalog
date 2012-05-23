package com.myonlinebd.catalog.client.accountcreation;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.myonlinebd.catalog.client.comunication.BusinessCardsRequestFactory;
import com.myonlinebd.catalog.client.navigation.AbstractActivity;
import com.myonlinebd.catalog.shared.entities.AccountProxy;
import com.myonlinebd.catalog.shared.entities.AddressProxy;
import com.myonlinebd.catalog.shared.entities.CompanyProxy;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class AccountCreatorWorkflowImpl extends AbstractActivity implements AccountCreatorWorkflow {

  private AccountCreatorWorkflowView workflowView;
  private BusinessCardsRequestFactory.AccountContext accountRequestContext;


  @Inject
  public AccountCreatorWorkflowImpl(BusinessCardsRequestFactory.AccountContext accountRequestContext, AccountCreatorWorkflowView workflowView) {
    this.accountRequestContext = accountRequestContext;
    this.workflowView = workflowView;
  }

  @Override
  public void createAccount(BusinessCardsRequestFactory.AccountContext context) {
    workflowView.disableSubmitButton();
    context.fire();
  }

  @Override
  public void onEditing() {
    workflowView.clearNotificationMessage();
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
//    accountRequestContext = factory.accountContext();
    workflowView.setWorkflow(this);
    panel.setWidget(workflowView.asWidget());
  }
}
