package com.myonlinebd.catalog.server.domain;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */

public class Company {


    private String companyName;

    private Long id;

//    public Company() {
//    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


}
