package com.atguigu.ioc_01.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@ComponentScan("com.atguigu.ioc_01")
@PropertySource(value = "classpath:jdbc.properties")
@Configuration
public class JavaConfiguration {

}
