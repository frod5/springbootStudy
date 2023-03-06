package com.helloboot.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

@JdbcTest //사용하면 임베디드 디비를 사용하여 조금더 빠르게 테스트가능.
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
