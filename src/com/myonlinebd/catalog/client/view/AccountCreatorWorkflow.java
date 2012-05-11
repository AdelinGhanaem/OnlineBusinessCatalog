package com.myonlinebd.catalog.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.validation.client.Validation;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.myonlinebd.catalog.client.RequestFactory.BusinessCardsRequestFactory;
import com.myonlinebd.catalog.client.presenter.AccountCreatorPresenter;
import com.myonlinebd.catalog.shared.ClientGroup;
import com.myonlinebd.catalog.shared.entities.AccountProxy;
import com.myonlinebd.catalog.shared.entities.ResponseProxy;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.Set;


/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class AccountCreatorWorkflow extends Composite {


  //  interface AccountCreatorWorkflowBinder extends UiBinder<HTMLPanel, AccountCreatorWorkflow> {
//  }
//
  AccountCreatorWorkflowBinder binder = GWT.create(AccountCreatorWorkflowBinder.class);

  //
//  @UiField
//  Label label;
//
//  public AccountCreatorWorkflow() {
//    initWidget(binder.createAndBindUi(this));
//  }
//
//
  public void show(HasWidgets hasWidgets) {
    hasWidgets.clear();
    hasWidgets.add(this.asWidget());
  }


  interface AccountCreatorWorkflowBinder extends UiBinder<DecoratorPanel, AccountCreatorWorkflow> {
  }


  //The Editor Driver
  interface Driver extends RequestFactoryEditorDriver<AccountProxy, AccountEditor> {
  }

  private Driver driver;


  private BusinessCardsRequestFactory factory;

  private AccountCreatorPresenter presenter;

  BusinessCardsRequestFactory.AccountContext context;

  @UiField()
  AccountEditor accountEditor;

  AccountProxy proxy;

  @UiField
  Button submit;

  Receiver<ResponseProxy> receiver;

  public AccountCreatorWorkflow(BusinessCardsRequestFactory requestFactory, AccountCreatorPresenter creatorPresenter) {

    initWidget(binder.createAndBindUi(this));

    presenter = creatorPresenter;

    factory = requestFactory;

    driver = GWT.create(Driver.class);
    //initialize the drive with factory and account editor
    driver.initialize(factory, accountEditor);

    //save the proxy on the server
    context = factory.accountContext();
    //create the proxy
    proxy = context.create(AccountProxy.class);
    //return a mutable proxy
    proxy = context.edit(proxy);

    //start drive the editor
    driver.edit(proxy, context);
  }

  //TODO:it seems like we have  to persist the object before then pass it to the editor  .... !
  @UiHandler("submit")
  public void onSubmit(ClickEvent event) {

    //copy the fields into the proxy
    driver.flush();
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    Set<ConstraintViolation<AccountProxy>> violations = validator.validate(proxy, Default.class, ClientGroup.class);
    if (violations.isEmpty()) {
      presenter.createAccount(context, proxy, new Receiver<ResponseProxy>() {
        @Override
        public void onSuccess(ResponseProxy response) {
          Window.alert("So far so good !");
        }
      });
    } else {

      Window.alert("Like u made it ?!" + "  " + violations.toString());
    }

  }


}

