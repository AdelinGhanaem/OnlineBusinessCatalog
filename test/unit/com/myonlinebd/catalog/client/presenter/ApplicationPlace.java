package com.myonlinebd.catalog.client.presenter;

import com.google.gwt.place.shared.Place;

/**
* @author Adelin Ghanayem adelin.ghanaem@clouway.com
*/
public class ApplicationPlace extends Place {


  private String placeId;

  ApplicationPlace(String placeId) {
    this.placeId = placeId;
  }

  public ApplicationPlace() {

  }

  public String getPlaceId() {
    return placeId;
  }
}
