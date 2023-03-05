package com.helloboot.helloboot.service.v1.impl;

import com.helloboot.helloboot.repository.HelloRepository;
import com.helloboot.helloboot.service.HelloService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service //서비스 계층에 사용. 안에 들어가면 결국 @Component 존재.
public class SimpleHelloService implements HelloService {

    private final HelloRepository helloRepository;

    public SimpleHelloService(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }


    @Override
    public int countOf(String name) {
        return this.helloRepository.countOf(name);
    }

    @Override
    public String sayHello(String name) {
        this.helloRepository.increaseCount(name);
        return "Hello " + name;
    }
}
