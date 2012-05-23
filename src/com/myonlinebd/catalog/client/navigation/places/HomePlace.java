package com.myonlinebd.catalog.client.navigation.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class HomePlace extends Place {


  public static class Tokenizer implements PlaceTokenizer<HomePlace> {

    @Override
    public HomePlace getPlace(String token) {
      return new HomePlace();
    }

    @Override
    public String getToken(HomePlace place) {
      return "home";
    }
  }


}
