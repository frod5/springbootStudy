package com.helloboot.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//사용자 구성 정보(ComponentScan)에서 @Configuration을 테스트 하기 위한 설정 정보.
@Configuration(proxyBeanMethods = false)
public class WebServerConfiguration {
    @Bean
    ServletWebServerFactory customWebServerFactory() {
        TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        serverFactory.setPort(9090);
        return serverFactory;
    }
}
