package com.myonlinebd.catalog.client.presenter;

import com.myonlinebd.catalog.client.RequestFactory.BusinessCardsRequestFactory;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.runner.RunWith;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
@RunWith(JMock.class)
public class AccountEditorPresenterTest {

  Mockery mockery = new Mockery();

  BusinessCardsRequestFactory requestFactory = mockery.mock(BusinessCardsRequestFactory.class);

  AccountEditorPresenter accountEditorPresenter = new AccountEditorPresenter();

  public void shouldEditAccountCorrectly() {
    mockery.checking(new Expectations() {{
    }});
  }
}
