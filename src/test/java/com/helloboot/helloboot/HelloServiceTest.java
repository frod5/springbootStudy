package com.helloboot.helloboot;

import com.helloboot.helloboot.repository.HelloRepository;
import com.helloboot.helloboot.service.HelloService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class HelloServiceTest {
    @Autowired
    HelloService helloService;

    @Autowired
    HelloRepository helloRepository;

    @Test
    void sayHelloIncreaseCount(){
        IntStream.rangeClosed(1,10).forEach(count-> {
            helloService.sayHello("Sunwoo");
            Assertions.assertThat(helloRepository.countOf("Sunwoo")).isEqualTo(count);
        });
    }
}
