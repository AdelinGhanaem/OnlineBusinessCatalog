package com.myonlinebd.catalog.client.presenter;

import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.myonlinebd.catalog.client.accountcreation.AccountCreatingReceiver;
import com.myonlinebd.catalog.client.accountcreation.AccountCreatorWorkflow;
import com.myonlinebd.catalog.client.accountcreation.AccountCreatorWorkflowImpl;
import com.myonlinebd.catalog.client.accountcreation.AccountCreatorWorkflowView;
import com.myonlinebd.catalog.client.comunication.BusinessCardsRequestFactory;
import com.myonlinebd.catalog.shared.entities.AccountProxy;
import com.myonlinebd.catalog.shared.entities.AddressProxy;
import com.myonlinebd.catalog.shared.entities.CompanyProxy;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
@RunWith(JMock.class)
public class AccountCreatorPresenterTest {

  Mockery context = new Mockery();

//  BusinessCardsRequestFactory requestFactory = context.mock(BusinessCardsRequestFactory.class);

  BusinessCardsRequestFactory.AccountContext accountContext = context.mock(BusinessCardsRequestFactory.AccountContext.class);

  RequestFactoryEditorDriver driver = context.mock(RequestFactoryEditorDriver.class);

  AccountCreatorWorkflowView workflowView = context.mock(AccountCreatorWorkflowView.class);


    AccountCreatorWorkflow workflow = new AccountCreatorWorkflowImpl(accountContext, workflowView);


  @Before
  public void setUp() {
  }

  @Test
  public void shouldDisableCreateButtonAndFireContext() {
    context.checking(new Expectations() {{
      oneOf(workflowView).disableSubmitButton();
      oneOf(accountContext).fire();
    }});
    workflow.createAccount(accountContext);
  }


  @Test
  public void onEditingShouldClearNotificationMessage() {
    context.checking(new Expectations() {{
      oneOf(workflowView).clearNotificationMessage();
    }});
    workflow.onEditing();
  }


  @Test
  public void accountProxyMembersArePopulatedCorrectly() {
    final AccountProxy proxy = getTestAccountProxy();
    final AddressProxy addressProxy = getTestAddressProxy();
    final CompanyProxy companyProxy = getTestCompanyProxy();
    context.checking(new Expectations() {{
//      oneOf(requestFactory).accountContext();
//      will(returnValue(accountContext));
      oneOf(accountContext).create(AccountProxy.class);
      will(returnValue(proxy));
      oneOf(accountContext).create(AddressProxy.class);
      will(returnValue(addressProxy));
      oneOf(accountContext).create(CompanyProxy.class);
      will(returnValue(companyProxy));
    }});
    AccountProxy returnedProxy = workflow.getAccountProxy();
    assertThat(returnedProxy, is(notNullValue()));
    assertThat(returnedProxy.getAddress(), is(notNullValue()));
    assertThat(returnedProxy.getCompany(), is(notNullValue()));
  }


  @Test
  public void shouldPrepareForAccountCreationAndAttachReceiver() {
    final AccountProxy proxy = getTestAccountProxy();
    final Receiver<Void> receiver = new AccountCreatingReceiver(workflowView);
    context.checking(new Expectations() {{
      oneOf(accountContext).create(proxy).to(receiver);
    }});
    workflow.willCreate(proxy, receiver);
  }

  @Test
  public void shouldReturnTheAccountContext() {

    BusinessCardsRequestFactory.AccountContext returnedAccountContext = workflow.getAccountContext();

    assertThat(returnedAccountContext, is(notNullValue()));
  }


  private AccountProxy getTestAccountProxy() {
    return new AccountProxy() {

      AddressProxy addressProxy;
      CompanyProxy companyProxy;

      @Override
      public void setEmail(String email) {
        //To change body of implemented methods use File | Settings | File Templates.
      }

      @Override
      public void setPassword(String password) {
        //To change body of implemented methods use File | Settings | File Templates.
      }

      @Override
      public String getEmail() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
      }

      @Override
      public String getPassword() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
      }

      @Override
      public void setAddress(AddressProxy address) {
        addressProxy = address;
      }

      @Override
      public void setCompany(CompanyProxy company) {
        companyProxy = company;
      }

      @Override
      public AddressProxy getAddress() {
        return addressProxy;
      }

      @Override
      public CompanyProxy getCompany() {
        return companyProxy;
      }

      @Override
      public EntityProxyId<?> stableId() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
      }
    };
  }


  public AddressProxy getTestAddressProxy() {
    return new AddressProxy() {
      @Override
      public void setPostalCode(String postalCode) {
        //To change body of implemented methods use File | Settings | File Templates.
      }

      @Override
      public void setTown(String town) {
        //To change body of implemented methods use File | Settings | File Templates.
      }

      @Override
      public void setStreet(String street) {
        //To change body of implemented methods use File | Settings | File Templates.
      }

      @Override
      public String getStreet() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
      }

      @Override
      public String getPostalCode() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
      }

      @Override
      public String getTown() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
      }
    };

  }

  public CompanyProxy getTestCompanyProxy() {
    return new CompanyProxy() {
      @Override
      public String getCompanyName() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
      }

      @Override
      public void setCompanyName(String companyName) {
        //To change body of implemented methods use File | Settings | File Templates.
      }

      @Override
      public Long getId() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
      }

      @Override
      public void setId(Long id) {
        //To change body of implemented methods use File | Settings | File Templates.
      }

//      @Override
//      public EntityProxyId<?> stableId() {
//        return null;  //To change body of implemented methods use File | Settings | File Templates.
//      }
    };
  }
}
