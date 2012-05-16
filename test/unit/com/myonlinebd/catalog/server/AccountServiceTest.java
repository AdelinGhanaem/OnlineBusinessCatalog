package com.myonlinebd.catalog.server;

import com.myonlinebd.catalog.server.domain.Account;
import com.myonlinebd.catalog.server.domain.Address;
import com.myonlinebd.catalog.server.domain.Company;
import com.myonlinebd.catalog.server.domain.Response;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
@RunWith(JMock.class)
public class AccountServiceTest {


  Mockery context = new Mockery();
  AccountRepository repository = context.mock(AccountRepository.class);
  EntityValidator<Account> entityValidator = context.mock(EntityValidator.class);
  private final AccountService service = new AccountServiceImpl(repository);
  private final Account account = new Account();
  private final Address address = new Address();
  private final Company company = new Company();
  private final String email = "mail@mail.com";
  private final String password = "password123";

  @Before
  public void setUp() {
    account.setEmail("mail@mail.com");
    account.setPassword("pas123456");
    account.setAddress(address);
    account.setCompany(company);
    account.setId(1l);
  }


  @Test
  public void shouldCreateAccount() {
    context.checking(new Expectations() {{
      oneOf(entityValidator).validate(account);
      will(returnValue(new ArrayList<String>()));
      oneOf(repository).createAccount(account);
    }});
    Response returnedResponse = service.create(account);
    assertThat(returnedResponse, is(notNullValue()));
    assertThat(returnedResponse.getErrorMessageList().size(), is(0));
  }


  @Test
  public void creatingAccountWithEmptyEmailIsNotAllowed() {
    final String emptyEmailMessage = "bla bla";
    account.setEmail("");
    context.checking(new Expectations() {{
      oneOf(entityValidator).validate(account);
      will(returnValue(new ArrayList<String>() {{
        add(emptyEmailMessage);
      }}));
      never(repository).createAccount(account);
    }});
    Response returnedResponse = service.create(account);
    assertThat(returnedResponse, is(notNullValue()));
    assertThat(returnedResponse.getErrorMessageList().size(), is(1));
    assertThat(returnedResponse.getErrorMessageList().contains(emptyEmailMessage), is(true));
  }


  @Test
  public void creatingAccountWithEmptyPasswordIsNotAllowed() {
    final String emptyPasswordMessage = "empty password !";
    account.setPassword("");
    context.checking(new Expectations() {{
      oneOf(entityValidator).validate(account);
      will(returnValue(new ArrayList<String>() {{
        add(emptyPasswordMessage);
      }}));
      never(repository).createAccount(account);
    }});
    Response returnedResponse = service.create(account);
    assertThat(returnedResponse, is(notNullValue()));
    assertThat(returnedResponse.getErrorMessageList().size(), is(1));
    assertThat(returnedResponse.getErrorMessageList().contains(emptyPasswordMessage), is(true));
  }

}
