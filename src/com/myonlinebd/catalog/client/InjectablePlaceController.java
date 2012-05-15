package com.myonlinebd.catalog.client;

import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class InjectablePlaceController extends PlaceController{
  
  @Inject
  public InjectablePlaceController(EventBus eventBus) {
    super(eventBus);
  }
}
