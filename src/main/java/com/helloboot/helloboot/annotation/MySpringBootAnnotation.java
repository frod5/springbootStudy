package com.helloboot.helloboot.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) // TYPE은 class, interface, enum에 적용할 때 사용.
@ComponentScan(basePackages = "com.helloboot.helloboot")
@Configuration
public @interface MySpringBootAnnotation {
}
