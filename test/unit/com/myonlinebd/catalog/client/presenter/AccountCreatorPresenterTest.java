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

  BusinessCardsRequestFactory requestFactory = context.mock(BusinessCardsRequestFactory.class);

  BusinessCardsRequestFactory.AccountContext accountContext = requestFactory.accountContext();

  AccountCreatorView view = context.mock(AccountCreatorView.class);


  @Test
  public void shouldDisableButtonAndCreateNewAccount() {

    context.checking(new Expectations() {{

      oneOf(view).disableSubmitButton();
      oneOf(requestFactory).accountContext();
      will(returnValue(accountContext));

    }});

    AccountCreatorPresenter presenter = new AccountCreatorPresenterImpl();

  }


}
