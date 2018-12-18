/*
 * Copyright (c) 2018. Toxic
 */

package com.toxic.generate.tool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author py
 * @date 2018/11/25 10:17 PM.
 */
@EnableTransactionManagement
@SpringBootApplication
public class GenerateApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(GenerateApplication.class, args);
    }

    @Override//为了打包springboot项目
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }

}
