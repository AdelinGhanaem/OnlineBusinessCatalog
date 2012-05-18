package com.myonlinebd.catalog.shared.entities;

import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.ValueProxy;
import com.myonlinebd.catalog.server.domain.Company;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
@ProxyFor(value = Company.class)
public interface CompanyProxy extends ValueProxy {


  public String getCompanyName();

  public void setCompanyName(String companyName);

  public Long getId();

  public void setId(Long id);

}
