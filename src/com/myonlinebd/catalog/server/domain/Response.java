package com.myonlinebd.catalog.server.domain;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class Response {


    private String responseMessage;

    public Response(String message) {
        responseMessage = message;
    }

    @SuppressWarnings("unused")
    public Response() {

    }


    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
