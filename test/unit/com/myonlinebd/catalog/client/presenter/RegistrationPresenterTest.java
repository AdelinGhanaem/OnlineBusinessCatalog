package com.myonlinebd.catalog.client.presenter;

import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import com.myonlinebd.catalog.client.RequestFactory.AccountContext;
import com.myonlinebd.catalog.client.RequestFactory.BusinessCardsRequestFactory;
import com.myonlinebd.catalog.client.view.AccountCreatorView;
import com.myonlinebd.catalog.shared.ResponseProxy;
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
  private AccountContext accountContext = context.mock(AccountContext.class);
  private AccountCreatorView view = context.mock(AccountCreatorView.class);
  private final String password = "password";
  private final String validEmail = "validEmail@mail.com";
  private Request<ResponseProxy> accountRequest = context.mock(Request.class);

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
  public void shouldCreateANewRegistrationAndReturnResponse() {
    context.checking(new Expectations() {{
      oneOf(requestFactory).accountContext();
      will(returnValue(accountContext));
      oneOf(accountContext).create(validEmail, password);
      will(returnValue(accountRequest));
      oneOf(accountRequest).fire(receiver);
    }});
     accountCreatorPresenter.createAccount(validEmail, password, receiver);
  }

  @Test
  public void providingInvalidEmailIsNotAllowed() {
    final String invalidEmail = "invalidEmail";
    context.checking(new Expectations() {{
      oneOf(view).notifyOfInvalidEmail();
      never(requestFactory).accountContext();
      never(accountContext).create(invalidEmail, password);
      never(accountRequest).fire(receiver);
    }});
    accountCreatorPresenter.createAccount(invalidEmail, password, receiver);
  }

  @Test
  public void providingAnotherInvalidEmailIsNotAllowed() {
    final String anotherInvalidEmail = "anotherInvalidEmail";
    context.checking(new Expectations() {{
      oneOf(view).notifyOfInvalidEmail();
      never(requestFactory).accountContext();
      never(accountContext).create(anotherInvalidEmail, password);
      never(accountRequest).fire(receiver);
    }});
    accountCreatorPresenter.createAccount(anotherInvalidEmail, password, receiver);
  }

  @Test
  public void providingPasswordLessThanEightCharactersIsNotAllowed() {
    final String shortPassword = "123";
    context.checking(new Expectations() {{
      oneOf(view).notifyOfInvalidPassword();
      never(requestFactory).accountContext();
      never(accountContext).create(validEmail, shortPassword);
      never(accountRequest).fire(receiver);
    }});
    accountCreatorPresenter.createAccount(validEmail, shortPassword, receiver);
  }




}
