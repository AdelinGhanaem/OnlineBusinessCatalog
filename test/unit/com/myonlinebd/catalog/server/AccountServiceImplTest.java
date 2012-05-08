package com.myonlinebd.catalog.server;

import com.myonlinebd.catalog.server.domain.Account;
import com.myonlinebd.catalog.server.domain.Response;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
@RunWith(JMock.class)
public class AccountServiceImplTest {

  private Mockery context = new Mockery();

  private AccountRepository accountRepository = context.mock(AccountRepository.class);
  private ResponseFactory responseFactory = context.mock(ResponseFactory.class);
  private AccountService accountService = new AccountServiceImpl(accountRepository, responseFactory);


  @Test
  public void shouldCreateAccount() {
    final Response response = new Response("user created");
    final String accountEmail = "email@mail.com";
    final String password = "password";
    context.checking(new Expectations() {{
      oneOf(accountRepository).create(accountEmail, password);
      oneOf(responseFactory).accountCreated();
      will(returnValue(response));
    }});
    Response returnedResponse = accountService.create(accountEmail, password);
    assertThat(returnedResponse.getResponseMessage(), equalTo(response.getResponseMessage()));
  }

    @Test
  public void invalidEmailIsNotAllowedAndShouldReturnErrorResponse() {
    final Response response = new Response("Invalid email !");
    final String invalidEmail = "invalidEmail";
    final String password = "anotherPassword";
    context.checking(new Expectations() {{
      never(accountRepository).create(invalidEmail, password);
      oneOf(responseFactory).invalidEmail();
      will(returnValue(response));
    }});
    Response returnedResponse = accountService.create(invalidEmail, password);
    assertThat(returnedResponse.getResponseMessage(), equalTo(response.getResponseMessage()));
  }

  @Test
  public void anotherInvalidEmailIsNotAllowed() {
    final Response response = new Response("The email is not valid !!");
    final String anotherInvalidEmail = "anotherInvalidEmail";
    final String password = "password111";
    context.checking(new Expectations() {{
      never(accountRepository).create(anotherInvalidEmail, password);
      oneOf(responseFactory).invalidEmail();
      will(returnValue(response));
    }});
    accountService.create(anotherInvalidEmail, password);
  }


  @Test
  public void shortPasswordIsNotAllowed() {
    final Response response = new Response("short password ! ");
    final String validEmail = "valid@mail.com";
    final String shortPassword = "short";
    context.checking(new Expectations() {{
      never(accountRepository).create(validEmail, shortPassword);
      oneOf(responseFactory).shortPassword();
      will(returnValue(response));
    }});
    accountService.create(validEmail, shortPassword);
  }

  @Test
  public void shouldReturnAccountWhenAccountExists() {
    final Account account = new Account(1l, "email@mail.com");
    context.checking(new Expectations() {{
      oneOf(accountRepository).getAccountById(1l);
      will(returnValue(account));
    }});
    Account returnedAccount = accountService.getAccountById(1l);
    assertThat(account.getId(), equalTo(returnedAccount.getId()));
    assertThat(account.getEmail(), equalTo(returnedAccount.getEmail()));
  }
//
//  //TODO:eliminate the if else in the in Account service  !!

}
