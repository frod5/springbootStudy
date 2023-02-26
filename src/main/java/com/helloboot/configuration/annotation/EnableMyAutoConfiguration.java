package com.helloboot.configuration.annotation;

import com.helloboot.configuration.autoconfig.DispatcherServeltConfiguration;
import com.helloboot.configuration.autoconfig.TomcatWebServerConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({TomcatWebServerConfiguration.class
        , DispatcherServeltConfiguration.class
})
public @interface EnableMyAutoConfiguration {
}
