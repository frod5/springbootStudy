package com.helloboot.configuration.autoconfig;

import com.helloboot.configuration.annotation.ConditionalMyOnClass;
import com.helloboot.configuration.annotation.MyAutoConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.env.Environment;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
//@Conditional(TomcatWebServerConfiguration.TomcatCondition.class)
//@Condition은 @Configuration에서 사용할 경우 해당 Configuration붙은 클래스에 대해 맞는거만 빈생성을 하고,
//@Bean 즉, 메소드 단위에서 사용할 경우 해당빈을 조건에 따라 생성.
//@Configuration 조건은 false인데 @Bean 조건이 true인 경우 ?? -> @Configuration이 true여야 @Bean 메소드까지 체크한다. false면 체크조차 하지않음
//사용자정보구성(ComponentScan) / 자동정보구성(AutoConfiguration)
//자동구성정보 보다 사용자 구성정보를 먼저 등록함 -> 자동구성정보에서 빈 생성시 사용자 구성정보에 이미 같은 빈이 있는 경우 생성안하도록 메소드 단위에서 처리 @ConditionalOnMissingBean
public class TomcatWebServerConfiguration {

    @Bean("tomcatWebSeverFactory")
    @ConditionalOnMissingBean //사용자 구성정보에서 해당 빈이 있는 경우 빈 생성x
    public ServletWebServerFactory servletWebServerFactory(ServerProperties serverProperties) {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.setContextPath(serverProperties.getContextPath());
        factory.setPort(serverProperties.getPort());
        return factory;
    }


}
