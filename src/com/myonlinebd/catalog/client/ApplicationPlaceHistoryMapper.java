package com.myonlinebd.catalog.client;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.myonlinebd.catalog.client.place.AccountCreatorPlace;
import com.myonlinebd.catalog.client.place.HomePlace;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
@WithTokenizers({AccountCreatorPlace.Tokenizer.class, HomePlace.Tokenizer.class})
public interface ApplicationPlaceHistoryMapper extends PlaceHistoryMapper {

}
