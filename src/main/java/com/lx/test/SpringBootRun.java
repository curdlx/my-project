package com.lx.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Generated;
import javax.servlet.MultipartConfigElement;

/**
 * Created by lx199 on 2016/5/12.
 */
@SpringBootApplication
@MapperScan("com.lx.test.repository")
public class SpringBootRun extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {



    @Override
    public SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(SpringBootRun.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRun.class,args);
    }
//    @Bean
//    public MultipartConfigElement multipartConfigElement() {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        factory.setMaxFileSize("512000KB");
//        factory.setMaxRequestSize("512000KB");
//        return factory.createMultipartConfig();
//    }

//    @Bean
//    public CommonsMultipartResolver multipartResolver() {
//        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//        multipartResolver.setDefaultEncoding("UTF-8");
//        return multipartResolver;
//    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer configure) {
        configure.setPort(8585);
    }
}
