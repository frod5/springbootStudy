package com.helloboot.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;

public class ApiTest {
    @Test
    void helloApi() {
        TestRestTemplate rest = new TestRestTemplate();
        String url = "http://localhost:8080/hello/{name}";
        ResponseEntity<String> res = rest.getForEntity(url, String.class, "SpringBoot");

        //응답검증
        //status 200
        Assertions.assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);

        //header(content-type) text/plain (인코딩은 제외)
        Assertions.assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);

        //body hello SpringBoot
        Assertions.assertThat(res.getBody()).isEqualTo("Hello SpringBoot");
    }
}