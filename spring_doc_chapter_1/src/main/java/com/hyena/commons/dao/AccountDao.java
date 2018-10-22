package com.hyena.commons.dao;

import com.hyena.commons.service.Service;

public class AccountDao {


    private Service service;


    public AccountDao() {
        //default constructor
    }


    // 面向接口
    public AccountDao(Service service) {
        this.service = service ;
    }

    public void setService(Service service) {
        this.service = service ;
    }



}
