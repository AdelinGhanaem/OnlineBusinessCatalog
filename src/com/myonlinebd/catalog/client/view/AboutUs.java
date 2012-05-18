package com.myonlinebd.catalog.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class AboutUs {
  interface AboutUsUiBinder extends UiBinder<DivElement, AboutUs> {
  }

  private static AboutUsUiBinder ourUiBinder = GWT.create(AboutUsUiBinder.class);

  public AboutUs() {
    DivElement rootElement = ourUiBinder.createAndBindUi(this);

  }
}