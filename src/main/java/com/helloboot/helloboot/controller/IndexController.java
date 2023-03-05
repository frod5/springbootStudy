package com.helloboot.helloboot.controller;

import com.helloboot.helloboot.service.HelloService;
import org.springframework.web.bind.annotation.*;

@RequestMapping
//@Controller 들어가면 결국 @Component 존재.
//@MyComponent
@RestController //타고들어가면 @Controller 와 @ResponseBody 존재. 클래스에 붙이면 클래스안에 있는 메소드는 모두 리턴이 ResponseBody
public class IndexController {

    private final HelloService helloService;

//    @Autowired 스프링 4.3부터는 생략가능.
    public IndexController(HelloService helloService) {
        this.helloService=helloService;
    }

    @GetMapping("/hello/{name}")
    @ResponseBody // Controller에 @RestController 어노테이션이 있으면 모든 메소드에 사실상 ResponseBody가 붙는것.
    public String hello(@PathVariable String name) {

        if(null == name || name.trim().length() == 0){
            throw new IllegalArgumentException();
        }
        return helloService.sayHello(name);
    }

    @GetMapping("/hello/count/{name}")
    @ResponseBody // Controller에 @RestController 어노테이션이 있으면 모든 메소드에 사실상 ResponseBody가 붙는것.
    public String helloCount(@PathVariable String name) {

        if(null == name || name.trim().length() == 0){
            throw new IllegalArgumentException();
        }
        return name+ ": " +helloService.countOf(name);
    }
}
