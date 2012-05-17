package com.myonlinebd.catalog.client.presenter;

import com.myonlinebd.catalog.client.requestfactory.BusinessCardsRequestFactory;
import com.myonlinebd.catalog.client.view.AccountCreatorView;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
@RunWith(JMock.class)
public class AccountCreatorPresenterTest {

  Mockery context = new Mockery();


  BusinessCardsRequestFactory.AccountContext accountContext = context.mock(BusinessCardsRequestFactory.AccountContext.class);

  AccountCreatorView view = context.mock(AccountCreatorView.class);


  AccountCreatorPresenter presenter = new AccountCreatorPresenterImpl(view);


  @Test
  public void shouldDisableCreateButtonAndFireContext() {
    context.checking(new Expectations() {{
      oneOf(view).disableSubmitButton();
      oneOf(accountContext).fire();
    }});
    presenter.createAccount(accountContext);
  }


  @Test
  public void shouldEnableCreateButtonAndGoToAccountCreatedPlace() {
    context.checking(new Expectations() {{

    }});
  }

}
