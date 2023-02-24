package com.helloboot.helloboot.controller;

import com.helloboot.helloboot.service.SimpleHelloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

//@RequestMapping({"/v1/test"})
//@RestController
public class IndexController {
    //@GetMapping("/{name}")
    public String hello(@PathVariable String name) {
        SimpleHelloService simpleHelloService = new SimpleHelloService();
        return simpleHelloService.sayHello(Objects.requireNonNull(name));
    }
}
