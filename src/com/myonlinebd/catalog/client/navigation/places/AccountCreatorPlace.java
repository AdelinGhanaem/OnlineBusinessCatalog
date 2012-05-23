package com.myonlinebd.catalog.client.navigation.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class AccountCreatorPlace extends Place {

  public static class Tokenizer implements PlaceTokenizer<AccountCreatorPlace> {

    @Override
    public AccountCreatorPlace getPlace(String token) {
      return new AccountCreatorPlace();
    }

    @Override
    public String getToken(AccountCreatorPlace place) {
      return "createnewaccount";
    }
  }
}
