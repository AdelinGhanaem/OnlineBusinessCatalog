package com.myonlinebd.catalog.client.presenter;

import com.google.gwt.activity.shared.Activity;
import com.myonlinebd.catalog.client.requestfactory.BusinessCardsRequestFactory;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public interface AccountCreatorPresenter extends Activity {

  void createAccount(BusinessCardsRequestFactory.AccountContext context);

  void onAccountCreated();

  void onAccountValidationFailure(Set<ConstraintViolation<?>> violations);

  void onConnectionFailure();
}
