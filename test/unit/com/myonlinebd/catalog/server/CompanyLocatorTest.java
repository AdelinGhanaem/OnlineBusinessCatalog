package com.myonlinebd.catalog.server;

import com.myonlinebd.catalog.server.domain.Company;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * author webmaster1803@gmail.com
 */
public class CompanyLocatorTest {

    private CompanyLocator companyLocator = new CompanyLocator();

    @Test
    public void shouldReturnNewCompanyObject() {
        Company company = companyLocator.create(Company.class);
        assertThat(company, CoreMatchers.is(notNullValue()));
    }

    @Test
    public void shouldFindCompanyById() {
        Company company = companyLocator.find(Company.class, 12l);
        assertThat(company, is(Matchers.notNullValue()));
        assertThat(company.getId(), is(12l));
    }

    @Test
    public void shouldReturnCompanyClassType() {

        assertThat(Company.class, is(equalTo(companyLocator.getDomainType())));

    }

    @Test
    public void shouldReturnCompanyId() {
        Company company = new Company();
        company.setId(12l);
        assertThat(12l, is(equalTo(companyLocator.getId(company))));
    }

    @Test
    public void shouldReturnIdType() {
        assertThat(Long.class, is(equalTo(companyLocator.getIdType())));
    }


}
