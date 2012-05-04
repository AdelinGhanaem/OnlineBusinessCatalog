package com.myonlinebd.catalog.server.domain;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class Response {



  private String responseMessage;

  public Response(String message) {
    responseMessage = message;

  }

  public String getResponseMessage() {
    return responseMessage;
  }
}
