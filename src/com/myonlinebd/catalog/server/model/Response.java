package com.myonlinebd.catalog.server.model;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class Response {


  private String getResponseMessage;

  private String responseMessage;

  public Response(String message) {
    responseMessage = message;

  }

  public String getResponseMessage() {
    return responseMessage;
  }
}
