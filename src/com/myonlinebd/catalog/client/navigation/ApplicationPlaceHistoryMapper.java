package com.myonlinebd.catalog.client.navigation;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.myonlinebd.catalog.client.navigation.places.AccountCreatorPlace;
import com.myonlinebd.catalog.client.navigation.places.HomePlace;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
@WithTokenizers({AccountCreatorPlace.Tokenizer.class, HomePlace.Tokenizer.class})
public interface ApplicationPlaceHistoryMapper extends PlaceHistoryMapper {

}
