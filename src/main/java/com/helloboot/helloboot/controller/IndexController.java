package com.helloboot.helloboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RequestMapping({"/v1/test"})
//@RestController
public class IndexController {
    //@GetMapping("/{name}")
    public String hello(@PathVariable String name) {
        return name;
    }
}
