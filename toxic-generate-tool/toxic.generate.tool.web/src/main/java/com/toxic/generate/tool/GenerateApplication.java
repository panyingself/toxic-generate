/*
 * Copyright (c) 2018. Toxic
 */

package com.toxic.generate.tool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author py
 * @date 2018/11/25 10:17 PM.
 */
@EnableTransactionManagement
@SpringBootApplication
public class GenerateApplication {
    public static void main(String[] args) {
        SpringApplication.run(GenerateApplication.class, args);
    }
}
