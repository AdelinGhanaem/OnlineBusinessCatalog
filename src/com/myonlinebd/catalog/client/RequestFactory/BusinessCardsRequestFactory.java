package com.myonlinebd.catalog.client.RequestFactory;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.RequestFactory;
import com.google.web.bindery.requestfactory.shared.Service;
import com.myonlinebd.catalog.server.AccountServiceImpl;
import com.myonlinebd.catalog.server.MyServicesLocator;
import com.myonlinebd.catalog.shared.entities.AccountProxy;
import com.myonlinebd.catalog.shared.entities.ResponseProxy;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public interface BusinessCardsRequestFactory extends RequestFactory {

    @Service(value = AccountServiceImpl.class, locator = MyServicesLocator.class)
    public interface AccountContext extends RequestContext {

        public Request<ResponseProxy> create(String email, String password);

        public Request<AccountProxy> getAccountById(Long id);
    }

    AccountContext accountContext();
}
