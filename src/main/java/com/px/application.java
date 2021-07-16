package com.px;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.px.mapper")
@SpringBootApplication
public class application {
    public static void main(String[] args) {
        SpringApplication.run(application.class, args);
    }
}
