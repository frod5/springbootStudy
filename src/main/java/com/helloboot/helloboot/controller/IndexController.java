package com.helloboot.helloboot.controller;

import com.helloboot.helloboot.annotation.MyComponent;
import com.helloboot.helloboot.service.HelloService;
import com.helloboot.helloboot.service.v1.impl.SimpleHelloService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RequestMapping
//@Controller 들어가면 결국 @Component 존재.
//@MyComponent
@RestController //타고들어가면 @Controller 와 @ResponseBody 존재. 클래스에 붙이면 클래스안에 있는 메소드는 모두 리턴이 ResponseBody
public class IndexController {

    private final HelloService helloService;
    private final ApplicationContext applicationContext;

    public IndexController(HelloService helloService, ApplicationContext applicationContext) {
        this.helloService=helloService;
        this.applicationContext = applicationContext;

        System.out.println(applicationContext);
    }

    @GetMapping("/hello/{name}")
    @ResponseBody // Controller에 @RestController 어노테이션이 있으면 모든 메소드에 사실상 ResponseBody가 붙는것.
    public String hello(@PathVariable String name) {
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
