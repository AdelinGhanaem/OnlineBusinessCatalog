package com.myonlinebd.catalog.server;

import com.google.web.bindery.requestfactory.shared.Locator;
import com.myonlinebd.catalog.server.domain.Company;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class CompanyLocator extends Locator<Company, Long> {

    @Override
    public Company create(Class<? extends Company> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    @Override
    public Company find(Class<? extends Company> clazz, Long id) {
        Company company = new Company();
        company.setId(id);
        return company;
    }

    @Override
    public Class<Company> getDomainType() {
        return Company.class;
    }

    @Override
    public Long getId(Company domainObject) {
        return domainObject.getId();
    }

    @Override
    public Class<Long> getIdType() {
        return Long.class;
    }

    @Override
    public Object getVersion(Company domainObject) {
        return 1;
    }
}
