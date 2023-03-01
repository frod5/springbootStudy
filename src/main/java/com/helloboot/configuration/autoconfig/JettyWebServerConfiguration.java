package com.helloboot.configuration.autoconfig;

import com.helloboot.configuration.annotation.ConditionalMyOnClass;
import com.helloboot.configuration.annotation.MyAutoConfiguration;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

@MyAutoConfiguration
@ConditionalMyOnClass("org.eclipse.jetty.server.Server")
public class JettyWebServerConfiguration {
    @Bean("jettyWebSeverFactory")
    public ServletWebServerFactory servletWebServerFactory() {
        return new JettyServletWebServerFactory();
    }
}
