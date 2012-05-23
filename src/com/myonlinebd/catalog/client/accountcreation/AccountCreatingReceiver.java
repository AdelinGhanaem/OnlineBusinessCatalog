package com.myonlinebd.catalog.client.accountcreation;

import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */

public class AccountCreatingReceiver extends Receiver<Void> {

  private AccountCreatorWorkflowView workflowView;

  public AccountCreatingReceiver(AccountCreatorWorkflowView workflowView) {
    this.workflowView = workflowView;
  }

  @Override
  public void onSuccess(Void response) {
    workflowView.enableSubmitButton();
    workflowView.gotToSuccessPage();
  }

  @Override
  public void onConstraintViolation(Set<ConstraintViolation<?>> violations) {
    for (ConstraintViolation<?> violation : violations) {
      workflowView.showMessage(violation.getMessage());
    }
  }

  @Override
  public void onFailure(ServerFailure error) {
    workflowView.gotToFailurePage();
  }
}
