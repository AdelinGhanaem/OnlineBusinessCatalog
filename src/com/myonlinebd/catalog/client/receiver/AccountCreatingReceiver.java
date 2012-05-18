package com.myonlinebd.catalog.client.receiver;

import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;
import com.myonlinebd.catalog.client.view.AccountCreatorView;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class AccountCreatingReceiver extends Receiver<Void> {

  private AccountCreatorView view;

  public AccountCreatingReceiver(AccountCreatorView view) {
    this.view = view;
  }

  @Override
  public void onSuccess(Void response) {
    view.enableSubmitButton();
    view.showSuccessNotification();
  }

  @Override
  public void onConstraintViolation(Set<ConstraintViolation<?>> violations) {
    for (ConstraintViolation<?> violation : violations) {
      view.showMessage(violation.getMessage());
    }
  }

  @Override
  public void onFailure(ServerFailure error) {
    view.showFailureNotification();
  }



}
