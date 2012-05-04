package com.myonlinebd.catalog.server;

import com.myonlinebd.catalog.server.domain.Account;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
@RunWith(JMock.class)
public class AccountLocatorTest {

  private Mockery context = new Mockery();
  private AccountService service = context.mock(AccountService.class);
  private AccountLocator locator = new AccountLocator(service);

  @Test
  public void shouldCreateAccountClass() {
    Account account = locator.create(Account.class);
    assertThat(account, notNullValue());
  }

  @Test
  public void shouldReturnAccountWhenAccountExist() {
    final Long accountId = 123l;
    final Account account = new Account(accountId, "email@mail.com");
    context.checking(new Expectations() {{
      oneOf(service).getAccountById(accountId);
      will(returnValue(account));
    }});
    Account returnedAccount = locator.find(Account.class, accountId);
    assertThat(returnedAccount.getEmail(), equalTo(account.getEmail()));
    assertThat(returnedAccount.getId(), equalTo(account.getId()));
  }

  @Test
  public void shouldReturnNUllWhenAccountIsNotFound() {
    final Long nonExistingAccountId = 100l;
    context.checking(new Expectations() {{
      oneOf(service).getAccountById(nonExistingAccountId);
      will(returnValue(null));
    }});
    assertThat(locator.find(Account.class, nonExistingAccountId), nullValue());
  }

  @Test
  public void shouldReturnAccountTypeClass() {
    Class<Account> accountClass = Account.class;
    assertThat(accountClass, is(equalTo(locator.getDomainType())));
  }

  @Test
  public void shouldReturnAccountIdCorrectly() {
    Long accountId = 111l;
    Account account = new Account(accountId, "myEmail@mail.com");
    assertThat(accountId, is(equalTo(locator.getId(account))));
  }

  @Test
  public void shouldReturnIdTypeCorrectly() {
    Class<Long> longClass = Long.class;
    assertThat(longClass,is(equalTo(locator.getIdType())));
  }
}
