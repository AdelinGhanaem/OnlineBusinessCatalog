package com.myonlinebd.catalog.client.presenter;

import com.google.web.bindery.requestfactory.shared.ServerFailure;
import com.myonlinebd.catalog.client.accountcreation.AccountCreatingReceiver;
import com.myonlinebd.catalog.client.accountcreation.AccountCreatorWorkflowView;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.validation.ConstraintViolation;
import java.util.HashSet;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
@RunWith(JMock.class)
public class AccountCreatingReceiverTest {

  Mockery context = new Mockery();
  AccountCreatorWorkflowView workflow = context.mock(AccountCreatorWorkflowView.class);
  AccountCreatingReceiver receiver = new AccountCreatingReceiver(workflow);

  @Test
  public void shouldEnableCreateButtonAndGoToAccountSuccessfullyCreatedPage() {
    context.checking(new Expectations() {{
      oneOf(workflow).enableSubmitButton();
      oneOf(workflow).gotToSuccessPage();
    }});
    receiver.onSuccess(null);
  }

  @Test
  public void shouldGoToFailurePageOnFailure() {
    context.checking(new Expectations() {{
      oneOf(workflow).gotToFailurePage();
    }});
    receiver.onFailure(new ServerFailure());
  }


  @Test
  public void shouldShowErrorOnConstraintViolation() {
    final String message = "errorMeasdsadassage";
    context.checking(new Expectations() {{
      one(workflow).showMessage(message);
    }});
    receiver.onConstraintViolation(new HashSet<ConstraintViolation<?>>() {{
      add(new TestConstraintViolation() {
        @Override
        public String getMessage() {
          return message;
        }
      });
    }});
  }


  @Test
  public void tryWithMoreThanOneConstraintViolation() {
    final String invalidEmail = "invalid Message";
    final String invalidPassword = "bla bla brrr";
    context.checking(new Expectations() {{
      oneOf(workflow).showMessage(invalidEmail);
      oneOf(workflow).showMessage(invalidPassword);
    }});
    receiver.onConstraintViolation(new HashSet<ConstraintViolation<?>>() {{
      add(new TestConstraintViolation() {
        @Override
        public String getMessage() {
          return invalidEmail;
        }
      });
      add(new TestConstraintViolation() {
        @Override
        public String getMessage() {
          return invalidPassword;
        }
      });
    }});
  }


}
