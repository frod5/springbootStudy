package com.helloboot.helloboot;

import com.helloboot.helloboot.annotation.JdbcTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@JdbcTest
public class JdbcTemplateTest {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Test
    void insertAndQuery() {
        jdbcTemplate.update("insert into hello values(?,?)","Sunwoo",3);
        jdbcTemplate.update("insert into hello values(?,?)","Test",1);

        Long cnt = jdbcTemplate.queryForObject("select count(*) from hello", Long.class);
        Assertions.assertThat(cnt).isEqualTo(2);
    }
}
