package com.myonlinebd.catalog.client.presenter;

import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import com.myonlinebd.catalog.client.RequestFactory.BusinessCardsRequestFactory;
import com.myonlinebd.catalog.client.view.AccountCreatorView;
import com.myonlinebd.catalog.shared.entities.AccountProxy;
import com.myonlinebd.catalog.shared.entities.ResponseProxy;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */

@RunWith(JMock.class)
public class RegistrationPresenterTest {

  private Mockery context = new Mockery();
  private BusinessCardsRequestFactory requestFactory = context.mock(BusinessCardsRequestFactory.class);
  private BusinessCardsRequestFactory.AccountContext accountContext = context.mock(BusinessCardsRequestFactory.AccountContext.class);
  private AccountCreatorView view = context.mock(AccountCreatorView.class);
  private Request<ResponseProxy> accountRequest = context.mock(Request.class);
  private AccountProxy accountProxy = context.mock(AccountProxy.class);

  public interface ErrorMessages {

    public String invalidEmail();

    public String invalidPassword();

  }

  private Receiver<ResponseProxy> receiver = new Receiver<ResponseProxy>() {

    public void onSuccess(ResponseProxy response) {

    }
  };

  private AccountCreatorPresenter accountCreatorPresenter = new AccountCreatorPresenterImpl(requestFactory, view);


  @Test
  public void shouldCreateNewAccount() {

    context.checking(new Expectations() {{
      oneOf(requestFactory).accountContext();
      will(returnValue(accountContext));
      oneOf(accountContext).create(accountProxy);
    }});
    accountCreatorPresenter.createAccount(accountProxy);
  }


//  @Test
//  public void shouldCreateANewRegistrationAndReturnResponse() {
//    context.checking(new Expectations() {{
//      oneOf(requestFactory).accountContext();
//      will(returnValue(accountContext));
//      oneOf(accountContext).create(validEmail, password);
//      will(returnValue(accountRequest));
//      oneOf(accountRequest).fire(receiver);
//    }});
//    accountCreatorPresenter.create(validEmail, password, receiver);
//  }
//
//  @Test
//  public void providingInvalidEmailIsNotAllowed() {
//    final String invalidEmail = "invalidEmail";
//    context.checking(new Expectations() {{
//      oneOf(view).notifyOfInvalidEmail();
//      never(requestFactory).accountContext();
//      never(accountContext).create(invalidEmail, password);
//      never(accountRequest).fire(receiver);
//    }});
//    accountCreatorPresenter.create(invalidEmail, password, receiver);
//  }
//
//  @Test
//  public void providingAnotherInvalidEmailIsNotAllowed() {
//    final String anotherInvalidEmail = "anotherInvalidEmail";
//    context.checking(new Expectations() {{
//      oneOf(view).notifyOfInvalidEmail();
//      never(requestFactory).accountContext();
//      never(accountContext).create(anotherInvalidEmail, password);
//      never(accountRequest).fire(receiver);
//    }});
//    accountCreatorPresenter.create(anotherInvalidEmail, password, receiver);
//  }
//
//  @Test
//  public void providingPasswordLessThanEightCharactersIsNotAllowed() {
//    final String shortPassword = "123";
//    context.checking(new Expectations() {{
//      oneOf(view).notifyOfInvalidPassword();
//      never(requestFactory).accountContext();
//      never(accountContext).create(validEmail, shortPassword);
//      never(accountRequest).fire(receiver);
//    }});
//    accountCreatorPresenter.create(validEmail, shortPassword, receiver);
//  }


}
