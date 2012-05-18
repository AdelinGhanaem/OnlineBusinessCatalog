package com.myonlinebd.catalog.client.presenter;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.metadata.ConstraintDescriptor;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public abstract class TestConstraintViolation implements ConstraintViolation {


  public abstract String getMessage();

  @Override
  public String getMessageTemplate() {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public Object getRootBean() {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public Class getRootBeanClass() {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public Object getLeafBean() {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public Path getPropertyPath() {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public Object getInvalidValue() {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public ConstraintDescriptor<?> getConstraintDescriptor() {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }
}
