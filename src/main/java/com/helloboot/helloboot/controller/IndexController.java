package com.helloboot.helloboot.controller;

import com.helloboot.helloboot.service.HelloService;
import com.helloboot.helloboot.service.v1.impl.SimpleHelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@RequestMapping("/hello")
//@RestController
public class IndexController {

    private final HelloService helloService;

    public IndexController(HelloService helloService) {
        this.helloService=helloService;
    }


    @GetMapping("/{name}")
    @ResponseBody // Controller에 @RestController 어노테이션이 있으면 모든 메소드에 사실상 ResponseBody가 붙는것.
    public String hello(@PathVariable String name) {
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
