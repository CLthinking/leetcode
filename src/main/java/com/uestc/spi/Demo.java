package com.uestc.spi;

import com.uestc.spi.service.HelloService;

public class Demo {
    public static void main(String[] args) {
        HelloService helloService = ServiceProvder.open(HelloService.class);
        System.out.println(helloService.hello("CLthinking"));
    }
}
