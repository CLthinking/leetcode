package com.uestc.spi;

import java.util.ServiceLoader;

public class ServiceProvder {

    public static <T> T open(Class<T> service) {
        ServiceLoader<T> loader = ServiceLoader.load(service);
        return loader.iterator().next();
    }

}
