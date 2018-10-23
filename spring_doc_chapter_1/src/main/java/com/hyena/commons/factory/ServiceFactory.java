package com.hyena.commons.factory;

import com.hyena.commons.service.MyService;
import com.hyena.commons.service.Service;

public class ServiceFactory {

    private static Service service = new MyService();

    public static Service createServiceInstance() {
        return service;
    }


    public Service noStaticCreateBean() {
        return new MyService();
    }
}
