package com.helloboot.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@UnitTest
@interface FastUnitTest{

}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE,ElementType.METHOD})
@Test
@interface UnitTest {

}
public class ApiTest {
    //@UnitTest
    //@FastUnitTest
    @Test
    void helloApi() {
        TestRestTemplate rest = new TestRestTemplate();
        String url = "http://localhost:9090/app/hello/{name}";
        ResponseEntity<String> res = rest.getForEntity(url, String.class, "SpringBoot");

        //응답검증
        //status 200
        Assertions.assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);

        //header(content-type) text/plain (인코딩은 제외)
        Assertions.assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);

        //body hello SpringBoot
        Assertions.assertThat(res.getBody()).isEqualTo( "* Hello SpringBoot *");
    }
}
