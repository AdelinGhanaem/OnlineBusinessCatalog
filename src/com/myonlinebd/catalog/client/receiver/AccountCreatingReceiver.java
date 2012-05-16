package com.myonlinebd.catalog.client.receiver;

import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;
import com.myonlinebd.catalog.client.presenter.AccountCreatorPresenter;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class AccountCreatingReceiver extends Receiver<Void> {

  private AccountCreatorPresenter presenter;

  public AccountCreatingReceiver(AccountCreatorPresenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void onSuccess(Void response) {
    presenter.onAccountCreated();
  }

  @Override
  public void onConstraintViolation(Set<ConstraintViolation<?>> violations) {
    presenter.onAccountValidationFailure(violations);
  }

  @Override
  public void onFailure(ServerFailure error) {
    presenter.onConnectionFailure();
  }
}
