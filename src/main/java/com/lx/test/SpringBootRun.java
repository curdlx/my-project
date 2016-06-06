package com.lx.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lx199 on 2016/5/12.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
//@MapperScan("com.lx.test.repository")
public class SpringBootRun {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRun.class,args);
    }


}
