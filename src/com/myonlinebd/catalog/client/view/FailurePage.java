package com.myonlinebd.catalog.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class FailurePage {
  interface FailurePageUiBinder extends UiBinder<DivElement, FailurePage> {
  }

  private static FailurePageUiBinder ourUiBinder = GWT.create(FailurePageUiBinder.class);

  public FailurePage() {
    DivElement rootElement = ourUiBinder.createAndBindUi(this);

  }
}