package com.helloboot.helloboot.controller;

import com.helloboot.helloboot.service.HelloService;
import com.helloboot.helloboot.service.v1.impl.SimpleHelloService;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Objects;

//@RequestMapping({"/v1/test"})
//@RestController
public class IndexController {

    private final HelloService helloService;

    public IndexController(HelloService helloService) {
        this.helloService=helloService;
    }


    //@GetMapping("/{name}")
    public String hello(@PathVariable String name) {
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
