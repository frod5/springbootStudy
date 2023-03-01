package com.helloboot.configuration.autoconfig;

import com.helloboot.configuration.annotation.ConditionalMyOnClass;
import com.helloboot.configuration.annotation.MyAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
//@Conditional(TomcatWebServerConfiguration.TomcatCondition.class)
//@Condition은 @Configuration에서 사용할 경우 해당 Configuration붙은 클래스에 대해 맞는거만 빈생성을 하고,
//@Bean 즉, 메소드 단위에서 사용할 경우 해당빈을 조건에 따라 생성.
//@Configuration 조건은 false인데 @Bean 조건이 true인 경우 ?? -> @Configuration이 true여야 @Bean 메소드까지 체크한다. false면 체크조차 하지않음
public class TomcatWebServerConfiguration {
    @Bean("tomcatWebSeverFactory")
    public ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }
}
