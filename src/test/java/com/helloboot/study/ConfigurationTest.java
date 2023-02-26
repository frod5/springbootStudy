package com.helloboot.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ConfigurationTest {
    @Test
    void configuration() {
        //기본 자바에서는 Common클래스가 서로 다른 것인데, 스프링 컨테이너에서는 같은것으로 사용한다.
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(MyConfig.class);
        applicationContext.refresh();

        Bean1 bean1 = applicationContext.getBean(Bean1.class);
        Bean2 bean2 = applicationContext.getBean(Bean2.class);

        Assertions.assertThat(bean1.common).isSameAs(bean2.common);
    }
    @Test
    void proxyCommonMethod() {
        //프록시는 decorator처럼 중간에 중개하는 것이 아니라 새로 만들어서 확장하여 대치.
        //스프링 컨테이너를 사용하지 않고 (스프링 빈) 프록시처럼 사용하면 자바에서도 같은 클래스로 인식
        //@Configuration 어노테이션 proxyBeanMethods = false는 같은 클래스로 인식하지 않도록 하는것 default는 true
        MyConfigProxy myConfigProxy = new MyConfigProxy();
        Bean1 bean1 = myConfigProxy.bean1();
        Bean2 bean2 = myConfigProxy.bean2();

        Assertions.assertThat(bean1.common).isSameAs(bean2.common);
    }
    static class MyConfigProxy extends MyConfig {
        private Common common;
        @Override
        Common common() {
            if(this.common == null) this.common = super.common();

            return this.common;
        }

    }

    @Configuration
    static class MyConfig {
        @Bean
        Common common() {
            return new Common();
        }

        @Bean
        Bean1 bean1() {
            return new Bean1(common());
        }

        @Bean
        Bean2 bean2() {
            return new Bean2(common());
        }
    }

    static class Bean1 {
        private final Common common;

        Bean1(Common common){
            this.common = common;
        }
    }

    static class Bean2 {
        private final Common common;

        Bean2(Common common){
            this.common = common;
        }
    }

    static class Common {

    }
}
