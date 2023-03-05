package com.helloboot.configuration.autoconfig;

import com.helloboot.configuration.annotation.*;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.JdbcTransactionObjectSupport;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.Driver;

@MyAutoConfiguration
@ConditionalMyOnClass("org.springframework.jdbc.core.JdbcOperations")
@EnableMyConfigurationProperties(MyDataSourceProperties.class)
@EnableTransactionManagement //해당 어노테이션을 사용하면, @Transaction 어노테이션을 사용가능하게된다.
public class DataSourceConfig {

    @Bean
    @ConditionalMyOnClass("com.zaxxer.hikari.HikariDataSource")
    DataSource hikariDataSource(MyDataSourceProperties properties) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(properties.getDriverClassName());
        dataSource.setJdbcUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        return dataSource;
    }

    @Bean
    @ConditionalOnMissingBean
    DataSource dataSource(MyDataSourceProperties properties) throws ClassNotFoundException {
        SimpleDriverDataSource dataSource =  new SimpleDriverDataSource();
        dataSource.setDriverClass((Class<? extends Driver>) Class.forName(properties.getDriverClassName()));
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        return dataSource;
    }

    @Bean
    @ConditionalOnSingleCandidate(DataSource.class) // DataSource 빈 등록되어있는게 한개만 있는경우 이걸 사용한다는 어노테이션.
    @ConditionalOnMissingBean
    JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    @ConditionalOnSingleCandidate(DataSource.class) // DataSource 빈 등록되어있는게 한개만 있는경우 이걸 사용한다는 어노테이션.
    @ConditionalOnMissingBean
    JdbcTransactionManager jdbcTransactionManager(DataSource dataSource) {
        return new JdbcTransactionManager(dataSource);
    }
}
