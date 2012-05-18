package com.myonlinebd.catalog.client.presenter;

import com.google.gwt.activity.shared.Activity;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.myonlinebd.catalog.client.requestfactory.BusinessCardsRequestFactory;
import com.myonlinebd.catalog.shared.entities.AccountProxy;
import com.myonlinebd.catalog.shared.entities.ResponseProxy;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public interface AccountCreatorPresenter extends Activity {

   void createAccount(BusinessCardsRequestFactory.AccountContext context, AccountProxy accountProxy, Receiver<ResponseProxy> receiver);

}
