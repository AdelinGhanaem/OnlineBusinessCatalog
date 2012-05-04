package com.myonlinebd.catalog.server;

import com.myonlinebd.catalog.server.domain.Response;

/**
* @author Adelin Ghanayem adelin.ghanaem@clouway.com
*/
public interface ResponseFactory {

  Response invalidEmail();

  Response shortPassword();

  Response accountCreated();

}