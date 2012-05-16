package com.myonlinebd.catalog.client.presenter;

import com.google.web.bindery.requestfactory.shared.ServerFailure;
import com.myonlinebd.catalog.client.receiver.AccountCreatingReceiver;
import com.myonlinebd.catalog.client.view.AccountCreatorView;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.validation.ConstraintViolation;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
@RunWith(JMock.class)
public class AccountCreatingReceiverTest {

  Mockery mockery = new Mockery();

  AccountCreatorPresenter presenter = mockery.mock(AccountCreatorPresenter.class);

  AccountCreatorView view = mockery.mock(AccountCreatorView.class);

  AccountCreatingReceiver receiver = new AccountCreatingReceiver(presenter);

  @Test
  public void shouldCallPresenterOnSuccess() {
    mockery.checking(new Expectations() {{
      oneOf(presenter).onAccountCreated();
    }});
    receiver.onSuccess(null);
  }

  @Test
  public void shouldNotifyUserOfErrorOnConstraintViolation() {
    final Set<ConstraintViolation<?>> violations = new HashSet<ConstraintViolation<?>>();
    mockery.checking(new Expectations() {{
      oneOf(presenter).onAccountValidationFailure(violations);
    }});
    receiver.onConstraintViolation(violations);
  }

  @Test
  public void shouldCallPresenterOnFailure() {
    mockery.checking(new Expectations() {{
      oneOf(presenter).onConnectionFailure();
    }});
    receiver.onFailure(new ServerFailure());
  }


}
