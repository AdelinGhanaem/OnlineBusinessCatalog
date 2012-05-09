package com.myonlinebd.catalog.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.myonlinebd.catalog.client.RequestFactory.BusinessCardsRequestFactory;
import com.myonlinebd.catalog.client.presenter.AccountCreatorPresenter;
import com.myonlinebd.catalog.shared.entities.AccountProxy;
import com.myonlinebd.catalog.shared.entities.ResponseProxy;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class AccountCreatorWorkflow extends Composite implements AccountCreatorView {


  @Override
  public void notifyOfInvalidEmail() {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public void notifyOfInvalidPassword() {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public void setPresenter(AccountCreatorPresenter accountCreatorPresenter) {
    //To change body of implemented methods use File | Settings | File Templates.
  }


  interface AccountCreatorWorkflowBinder extends UiBinder<HTMLPanel, AccountCreatorWorkflow> {
  }


  //create the binder of the AccountCreatorWorkflow
  AccountCreatorWorkflowBinder binder = GWT.create(AccountCreatorWorkflowBinder.class);

  //The Editor Driver
  interface Driver extends RequestFactoryEditorDriver<AccountProxy, AccountEditor> {

  }


  private Driver driver;

  private EventBus eventBus;

  private BusinessCardsRequestFactory factory;
  BusinessCardsRequestFactory.AccountContext context;

  @UiField()
  AccountEditor accountEditor;

  AccountProxy proxy;

  @UiField
  Button submit;

  public AccountCreatorWorkflow(BusinessCardsRequestFactory requestFactory) {
    factory = requestFactory;
    context = factory.accountContext();
    initWidget(binder.createAndBindUi(this));
    driver = GWT.create(Driver.class);

    proxy = context.create(AccountProxy.class);
    proxy = context.edit(proxy);
    driver.initialize(factory, accountEditor);
    driver.edit(proxy, context);
  }


  public AccountCreatorWorkflow() {


  }


  private void createAccount(AccountProxy proxy) {

  }

  //TODO:it seems like we have  to persist the object before then pass it to the editor  .... !
  @UiHandler("submit")
  public void onSubmit(ClickEvent event) {
    driver.flush();
    context.create(proxy).fire(new Receiver<ResponseProxy>() {
      @Override
      public void onSuccess(ResponseProxy response) {
        Window.alert("FO FAR SO FUCKING GOOOOOOOOOOOOOOOOOOOD ! ");
      }
    });

  }

  @Override
  public Widget asWidget() {
    return this;
  }
}

