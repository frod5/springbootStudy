package com.helloboot.helloboot;

import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MySpringApplication {
    public static void run(Class<?> applicationClass, String... args) {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh();

                //Servelt Container 생성 및 실행
                ServletWebServerFactory tomcatServletWebServerFactory = this.getBean(ServletWebServerFactory.class);
                DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);
//                dispatcherServlet.setApplicationContext(this);

                WebServer webServer = tomcatServletWebServerFactory.getWebServer(servletContext -> {
                    servletContext.addServlet("dispatcherServelt", dispatcherServlet).addMapping("/*");
                });
                webServer.start();
            }
        };

        applicationContext.register(applicationClass);
        applicationContext.refresh();
    }
}
