package com.helloboot.helloboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@ComponentScan(basePackages = "com.helloboot.helloboot") //이 어노테이션이 붙은 클래스의 패키지안에 @Component 어노테이션을 가진 클래스를 Bean으로 등록. @Component의 장점은 해당 어노테이션만 붙이면 빈으로 생성. 단점으로는 나중에 정확히 어떤것이 Bean으로 들어가는지 파악할 때 @Component 붙은 것을 모두 찾아야한다.
public class HellobootApplication {

    @Bean
    public ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }
    public static void main(String[] args) {

        //Spring Container 생성
        SpringApplication.run(HellobootApplication.class, args);
    }
}
