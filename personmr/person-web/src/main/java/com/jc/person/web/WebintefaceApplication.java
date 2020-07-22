package com.jc.person.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jc.person.service","com.jc.person.web"})
@MapperScan(value = {"com.jc.person.dao"})
public class WebintefaceApplication  extends ServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(WebintefaceApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(WebintefaceApplication.class);
    }
}
