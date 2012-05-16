package com.myonlinebd.catalog.server;

import com.myonlinebd.catalog.server.domain.Account;

import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class AccountEntityValidator implements EntityValidator<Account> {

  private Validator entityValidator;

  public AccountEntityValidator(Validator entityValidator) {
    this.entityValidator = entityValidator;
  }


  @Override
  public List<String> validate(Account account) {

//    Set<ConstraintViolation<Account>> violations = entityValidator.validate(account);
//    List<String> errorMessage = new ArrayList<String>();
//    for (ConstraintViolation violation : violations) {
//      errorMessage.add(violation.getMessage());
//    }
//    return errorMessage;

    return new ArrayList<String>();
  }
}
