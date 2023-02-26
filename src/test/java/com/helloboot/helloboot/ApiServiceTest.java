package com.helloboot.helloboot;

import com.helloboot.helloboot.service.v1.decorator.HelloDecorator;
import com.helloboot.helloboot.service.v1.impl.SimpleHelloService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ApiServiceTest {
    @Test
    void SimpleHelloService() {
        SimpleHelloService simpleHelloService = new SimpleHelloService();
        String ret = simpleHelloService.sayHello("Test");


        Assertions.assertThat(ret).isEqualTo("Hello Test");
    }

    @Test
    void helloDecoratorTest() {
        HelloDecorator decorator = new HelloDecorator(name -> name);

        String ret = decorator.sayHello("Test");

        Assertions.assertThat(ret).isEqualTo("* Test *");
    }
}
