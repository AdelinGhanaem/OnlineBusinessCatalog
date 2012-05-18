package com.myonlinebd.catalog.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;
import com.myonlinebd.catalog.client.place.AccountSuccessfullyCreatedPlace;
import com.myonlinebd.catalog.client.place.FailurePage;
import com.myonlinebd.catalog.client.presenter.AccountCreatorPresenter;
import com.myonlinebd.catalog.client.receiver.AccountCreatingReceiver;
import com.myonlinebd.catalog.client.requestfactory.BusinessCardsRequestFactory;
import com.myonlinebd.catalog.shared.entities.AccountProxy;


/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class AccountCreatorWorkflow extends Composite implements AccountCreatorView {


  AccountCreatorWorkflowBinder binder = GWT.create(AccountCreatorWorkflowBinder.class);


  interface AccountCreatorWorkflowBinder extends UiBinder<HTMLPanel, AccountCreatorWorkflow> {

  }


  //The Editor Driver
  interface Driver extends RequestFactoryEditorDriver<AccountProxy, AccountEditor> {
  }

  private Driver driver;

  BusinessCardsRequestFactory.AccountContext context;


  @UiField()
  AccountEditor accountEditor;


  AccountProxy proxy;


  AccountCreatorPresenter presenter;

  @UiField
  Button submit;


  @UiField
  Label errorMessages;


  @UiField(provided = true)
  HeaderView header;


  PlaceController placeController;

  @Inject
  public AccountCreatorWorkflow(BusinessCardsRequestFactory requestFactory, PlaceController controller, AccountCreatorPresenter accountCreatorPresenter) {
    //TODO:ALLOOOO DI .... !! kakvo pravim ?
    header = new HeaderView(controller);
    placeController = controller;
    presenter = accountCreatorPresenter;

    initWidget(binder.createAndBindUi(this));

    driver = GWT.create(Driver.class);
    //initialize the drive with factory and account editor
    driver.initialize(requestFactory, accountEditor);

    //--!!--save the proxy on the server

//    context = requestFactory.accountContext();
    context = presenter.getAccountContext();

    //--!!--create the proxy
//    proxy = context.create(AccountProxy.class);

    proxy = presenter.getAccountProxy();
    //--!!--
//    proxy.setAddress(context.create(AddressProxy.class));

    //--!!-- Call in some of the presenter methods !!
//    context.create(proxy).to(new Receiver<Void>() {
//      @Override
//      public void onSuccess(Void aVoid) {
//        Window.alert("So far so good !");
//      }
//    });
    presenter.willCreate(proxy, new AccountCreatingReceiver(this));

    //return a mutable proxy
    proxy = context.edit(proxy);

    //start drive the editor
    driver.edit(proxy, context);
  }


  //TODO:it seems like we have  to persist the object before then pass it to the editor  .... !
  @UiHandler("submit")
  public void onSubmit(ClickEvent event) {
    driver.flush();
    if (proxy.getAddress() != null) {
//      Window.alert(proxy.getAddress().getStreet());
    }
    presenter.createAccount(context);
  }


  public Widget asWidget() {
    return this;
  }


  public void setPresenter(AccountCreatorPresenter accountCreatorPresenter) {
    presenter = accountCreatorPresenter;
  }

  @Override
  public void disableSubmitButton() {
<<<<<<< HEAD

=======
    submit.setEnabled(false);
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
  public void gotAccountSuccessfullyCreatedPage() {
    placeController.goTo(new AccountSuccessfullyCreatedPlace());
  }

  @Override
  public void gotToFailurePage() {
    placeController.goTo(new FailurePage());
  }

  @Override
  public void clearNotificationMessage() {
    errorMessages.setText("");
>>>>>>> ba526d77639e2941ca343c95de61af380b0e84cc
  }
}

