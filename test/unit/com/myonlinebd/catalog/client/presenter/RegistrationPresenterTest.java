package com.myonlinebd.catalog.client.presenter;

import com.google.web.bindery.requestfactory.shared.Receiver;
import com.myonlinebd.catalog.client.requestfactory.BusinessCardsRequestFactory;
import com.myonlinebd.catalog.client.view.AccountCreatorView;
import com.myonlinebd.catalog.shared.entities.AccountProxy;
import com.myonlinebd.catalog.shared.entities.ResponseProxy;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
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
  private AccountCreatorPresenter presenter = new AccountCreatorPresenterImpl( view);
  final Receiver<ResponseProxy> receiver = new Receiver<ResponseProxy>() {
    @Override
    public void onSuccess(ResponseProxy response) {
    }
  };

  final AccountProxy proxy = new TestAccountProxy();

  @Before
  public void setUp() {
    proxy.setEmail("Adelin_H@hotmail.com");
    proxy.setPassword("123456");
  }

  @Test
  public void shouldRegisterNewAccount() {
    context.checking(new Expectations() {{
      oneOf(accountContext).create(proxy).fire(receiver);
    }});
    proxy.setEmail("adelin_H@hotmail.com");
    presenter.createAccount(accountContext, proxy, receiver);
  }





}
