package com.hyena.commons.service;

public class MyService implements Service {


    public MyService() {
        //default constructor
    }

    @Override
    public void execute() {
        System.out.println("executed!");
    }
}
