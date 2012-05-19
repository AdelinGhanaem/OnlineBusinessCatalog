package com.myonlinebd.catalog.server.domain;

import java.util.List;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class Response {


  private List<String> errorMessageList;


  public Response() {

  }

  public Response(List<String> errorMessages) {
    errorMessageList = errorMessages;
  }

  public List<String> getErrorMessageList() {
    return errorMessageList;
  }

  public void setErrorMessageList(List<String> errorMessageList) {
    this.errorMessageList = errorMessageList;
  }
}
