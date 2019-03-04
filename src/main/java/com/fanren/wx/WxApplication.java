package com.fanren.wx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@MapperScan("com.fanren.wx")
@ComponentScan("com.fanren.wx")
@SpringBootApplication
public class WxApplication {

    public static void main(String[] args) {

        SpringApplication.run(WxApplication.class, args);
    }

}

