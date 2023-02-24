package com.helloboot.helloboot.service.v1.impl;

import com.helloboot.helloboot.service.HelloService;

public class SimpleHelloService implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
