package com.uestc.spi.serviceimpl;

import com.uestc.spi.service.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "Hello , " + name + " !";
    }
}
