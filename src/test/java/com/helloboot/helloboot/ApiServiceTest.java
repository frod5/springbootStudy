package com.helloboot.helloboot;

import com.helloboot.helloboot.model.Hello;
import com.helloboot.helloboot.repository.HelloRepository;
import com.helloboot.helloboot.service.v1.decorator.HelloDecorator;
import com.helloboot.helloboot.service.v1.impl.SimpleHelloService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ApiServiceTest {
    @Test
    void SimpleHelloService() {
        SimpleHelloService simpleHelloService = new SimpleHelloService(helloRepositoryStub);
        String ret = simpleHelloService.sayHello("Test");


        Assertions.assertThat(ret).isEqualTo("Hello Test");
    }

    @Test
    void helloDecoratorTest() {
        HelloDecorator decorator = new HelloDecorator(name -> name);

        String ret = decorator.sayHello("Test");

        Assertions.assertThat(ret).isEqualTo("* Test *");
    }

    private static HelloRepository helloRepositoryStub = new HelloRepository() {
        @Override
        public Hello findHello(String name) {
            return null;
        }

        @Override
        public void increaseCount(String name) {

        }
    };
}
