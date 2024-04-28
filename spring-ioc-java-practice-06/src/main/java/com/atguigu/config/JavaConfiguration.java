package com.atguigu.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@PropertySource(value = "classpath:jdbc.properties")
@ComponentScan(basePackages = "com.atguigu")
@Configuration
public class JavaConfiguration {
    @Bean
    public DataSource dataSource(@Value("${atguigu.url}")String url, @Value("${atguigu.driver}")String driver,@Value("${atguigu.username}")String username, @Value("${atguigu.password}")String password) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;

    }
    @Bean
    public JdbcTemplate javaTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
}
