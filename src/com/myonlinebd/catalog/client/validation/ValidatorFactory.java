package com.myonlinebd.catalog.client.validation;

import com.google.gwt.core.client.GWT;
import com.google.gwt.validation.client.AbstractGwtValidatorFactory;
import com.google.gwt.validation.client.GwtValidation;
import com.google.gwt.validation.client.impl.AbstractGwtValidator;
import com.myonlinebd.catalog.shared.ClientGroup;
import com.myonlinebd.catalog.shared.entities.AccountProxy;
import com.myonlinebd.catalog.shared.entities.AddressProxy;

import javax.validation.Validator;
import javax.validation.groups.Default;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class ValidatorFactory extends AbstractGwtValidatorFactory {

  @GwtValidation(value = {AccountProxy.class, AddressProxy.class}, groups = {Default.class, ClientGroup.class})
  public interface GwtValidator extends Validator {

  }

  @Override
  public AbstractGwtValidator createValidator() {
      return GWT.create(GwtValidator.class);
  }
}
