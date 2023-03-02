package com.helloboot.configuration;

import com.helloboot.configuration.annotation.MySpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

//@Configuration
//@ComponentScan(basePackages = "com.helloboot.helloboot") //이 어노테이션이 붙은 클래스의 패키지안에 @Component 어노테이션을 가진 클래스를 Bean으로 등록. @Component의 장점은 해당 어노테이션만 붙이면 빈으로 생성. 단점으로는 나중에 정확히 어떤것이 Bean으로 들어가는지 파악할 때 @Component 붙은 것을 모두 찾아야한다.
@MySpringBootApplication  //합성 어노테이션 적용
public class HellobootApplication {

    @Bean
    ApplicationRunner applicationRunner(Environment environment) {
        return args -> {
            String name = environment.getProperty("my.name");
            //우선순위
            //1.servlet 설정 프로퍼티(web.xml, JNDI)
            //2.시스템 프로퍼티(VM옵션)
            //3.환경변수(Environment Variable)
            //4.application.properties파일에 선언된것.
            System.out.println(name);
        };
    }
    public static void main(String[] args) {
        //Spring Container 생성
        SpringApplication.run(HellobootApplication.class, args);
    }
}
