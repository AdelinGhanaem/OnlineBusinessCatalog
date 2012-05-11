package com.myonlinebd.catalog.client.validation;

import com.google.gwt.core.client.GWT;
import com.google.gwt.validation.client.AbstractGwtValidatorFactory;
import com.google.gwt.validation.client.impl.AbstractGwtValidator;

import javax.validation.Validator;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class AccountCreatorValidatorFactory extends AbstractGwtValidatorFactory {

//  @GwtValidation(value = Account.class,groups={Default.class,ClientGroup.class})
//  public interface Validator extends Validator {
//  }

  @Override
  public AbstractGwtValidator createValidator() {
    return GWT.create(Validator.class);
  }
}
