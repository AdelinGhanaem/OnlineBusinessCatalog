package com.myonlinebd.catalog.server;

import java.util.List;

/**
* @author Adelin Ghanayem adelin.ghanaem@clouway.com
*/
interface EntityValidator<T> {

  List<String> validate(T t);

}
