package com.helloboot.helloboot;

import com.helloboot.helloboot.controller.IndexController;
import com.helloboot.helloboot.service.HelloService;
import com.helloboot.helloboot.service.v1.impl.SimpleHelloService;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class HellobootApplication {
    @Bean
    public IndexController indexController(HelloService helloService) {
        return new IndexController(helloService);
    }

    @Bean
    public HelloService helloService() {
        return new SimpleHelloService();
    }

    public static void main(String[] args) {

        //Spring Container 생성
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh();

                //Servelt Container 생성 및 실행
                TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
                WebServer webServer = tomcatServletWebServerFactory.getWebServer(servletContext -> {
                    servletContext.addServlet("dispatcherServelt", new DispatcherServlet(this)).addMapping("/*");
                });
                webServer.start();

            }
        };

        applicationContext.register(HellobootApplication.class);
        applicationContext.refresh();
    }

}
