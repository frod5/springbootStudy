package com.helloboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;

//@Configuration
//@ComponentScan(basePackages = "com.helloboot.helloboot") //이 어노테이션이 붙은 클래스의 패키지안에 @Component 어노테이션을 가진 클래스를 Bean으로 등록. @Component의 장점은 해당 어노테이션만 붙이면 빈으로 생성. 단점으로는 나중에 정확히 어떤것이 Bean으로 들어가는지 파악할 때 @Component 붙은 것을 모두 찾아야한다.
@SpringBootApplication
public class HellobootApplication {

    //우선순위 evn.getProperty("my.name")
    //1.servlet 설정 프로퍼티(web.xml, JNDI)
    //2.시스템 프로퍼티(VM옵션)
    //3.환경변수(Environment Variable)
    //4.application.properties파일에 선언된것.

    private final JdbcTemplate jdbcTemplate;

    public HellobootApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    void init() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS hello(name varchar(50) primary key, count int)");
    }

    public static void main(String[] args) {
        //Spring Container 생성
        SpringApplication.run(HellobootApplication.class, args);
    }
}
