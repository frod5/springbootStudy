package com.helloboot.configuration;

import com.helloboot.configuration.annotation.ConditionalMyOnClass;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

import java.util.Map;

public class MyOnClassCondition implements Condition {
    //주로 라이브러리 클래스가 있는지 확인 후 분기.
    //@ConditionalMyOnClass("클래스")에 있는 어노테이션 정보를 가져온다. metadata.getAnnotationAttributes 사용.
    //키가 "value"로 지정한 값을 가져온다 @ConditionalMyOnClass("클래스")의 클래스
    //클래스를 가져와 클래스명이 있는지 확인 스프링라이브러리 ClassUtils.isPresent() 사용.
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attrs = metadata.getAnnotationAttributes(ConditionalMyOnClass.class.getName());
        String value = (String) attrs.get("value");
        return ClassUtils.isPresent(value,context.getClassLoader());
    }
}
