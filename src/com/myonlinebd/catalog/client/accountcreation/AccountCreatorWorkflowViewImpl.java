package com.myonlinebd.catalog.client.accountcreation;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;
import com.myonlinebd.catalog.client.accountcreation.view.AccountEditor;
import com.myonlinebd.catalog.client.comunication.BusinessCardsRequestFactory;
import com.myonlinebd.catalog.client.navigation.places.AccountSuccessfullyCreatedPlace;
import com.myonlinebd.catalog.client.navigation.places.FailurePagePlace;
import com.myonlinebd.catalog.client.navigation.HeaderView;
import com.myonlinebd.catalog.shared.entities.AccountProxy;


/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class AccountCreatorWorkflowViewImpl extends Composite implements AccountCreatorWorkflowView {

  AccountCreatorWorkflowBinder binder = GWT.create(AccountCreatorWorkflowBinder.class);

  interface AccountCreatorWorkflowBinder extends UiBinder<HTMLPanel, AccountCreatorWorkflowViewImpl> {

  }

  //The Editor Driver
  interface Driver extends RequestFactoryEditorDriver<AccountProxy, AccountEditor> {
  }

  private Driver driver;

  BusinessCardsRequestFactory.AccountContext context;


  @UiField()
  AccountEditor accountEditor;


  AccountProxy proxy;


  AccountCreatorWorkflow workflow;

  @UiField
  Button submit;


  @UiField
  Label errorMessages;


  @UiField(provided = true)
  HeaderView header;


  PlaceController placeController;

  @Inject
  public AccountCreatorWorkflowViewImpl(BusinessCardsRequestFactory requestFactory, PlaceController controller, HeaderView headerView) {

    header = headerView;
    placeController = controller;
    initWidget(binder.createAndBindUi(this));
    driver = GWT.create(Driver.class);
    driver.initialize(requestFactory, accountEditor);
  }


  //TODO:it seems like we have  to persist the object before then pass it to the editor  .... !
  @UiHandler("submit")
  public void onSubmit(ClickEvent event) {
    driver.flush();
    workflow.createAccount(context);
  }


  public Widget asWidget() {
    return this;
  }


  public void setWorkflow(AccountCreatorWorkflow accountCreatorWorkflow) {
    workflow = accountCreatorWorkflow;

    context = workflow.getAccountContext();

    proxy = workflow.getAccountProxy();
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!
    workflow.willCreate(proxy, new AccountCreatingReceiver(this));
    if (context == null) {
      Window.alert("no good ! ");

    } else {
      proxy = context.edit(proxy);
      driver.edit(proxy, context);
    }
  }

  @Override
  public void disableSubmitButton() {
    submit.setEnabled(false);
  }


  @Override
  public void gotToSuccessPage() {
    placeController.goTo(new AccountSuccessfullyCreatedPlace());
  }


  @Override
  public void showMessage(String violationMessages) {
    errorMessages.setText(violationMessages);
  }

  @Override
  public void enableSubmitButton() {
    submit.setEnabled(true);
  }


  @Override
  public void gotToFailurePage() {
    placeController.goTo(new FailurePagePlace());
  }

  @Override
  public void clearNotificationMessage() {
    errorMessages.setText("");
  }

}

