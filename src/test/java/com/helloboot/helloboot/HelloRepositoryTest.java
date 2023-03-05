package com.helloboot.helloboot;

import com.helloboot.helloboot.annotation.JdbcTest;
import com.helloboot.helloboot.repository.HelloRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@JdbcTest
public class HelloRepositoryTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    HelloRepository helloRepository;

    @BeforeEach
    void init() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS hello(name varchar(50) primary key, count int)");
    }

    @Test
    void findHelloFalid() {
        Assertions.assertThat(helloRepository.findHello("Sunwoo")).isNull();
    }

    @Test
    void increaseCount() {

        Assertions.assertThat(helloRepository.countOf("Sunwoo")).isEqualTo(0);

        helloRepository.increaseCount("Sunwoo");
        Assertions.assertThat(helloRepository.countOf("Sunwoo")).isEqualTo(1);

        helloRepository.increaseCount("Sunwoo");
        Assertions.assertThat(helloRepository.countOf("Sunwoo")).isEqualTo(2);
    }
}
