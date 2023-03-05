package com.helloboot.helloboot.service.v1.decorator;

import com.helloboot.helloboot.service.HelloService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary //HelloService에 AutoWiring에 의해 하나의 빈만 주입되어야하는데,해결방법으로는 설정파일 또는 우선순위설정(@Primary). 데코레이터가 많은경우 어노테이션 말고 다른 방법이 더 효율적.
public class HelloDecorator implements HelloService {

    private final HelloService helloService;

    public HelloDecorator(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public String sayHello(String name) {
        return "* "+helloService.sayHello(name)+ " *";
    }

    @Override
    public int countOf(String name) {
        return helloService.countOf(name);
    }
}
