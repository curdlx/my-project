package com.lx.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lx199 on 2016/5/12.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SpringBootRun {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRun.class,args);
    }


}
