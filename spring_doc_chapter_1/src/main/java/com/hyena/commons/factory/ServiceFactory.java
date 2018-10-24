package com.hyena.commons.factory;

import com.hyena.commons.beans.AnotherBean;
import com.hyena.commons.beans.YetAnotherBean;
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


    public static Service createServiceWithArg(AnotherBean anotherBean, YetAnotherBean
            yetAnotherBean, int i) {
        return new MyService();
    }
}
