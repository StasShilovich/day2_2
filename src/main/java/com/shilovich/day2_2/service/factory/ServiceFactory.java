package com.shilovich.day2_2.service.factory;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
