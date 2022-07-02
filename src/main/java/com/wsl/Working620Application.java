package com.wsl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@SpringBootApplication
public class Working620Application {

    public static void main(String[] args) {
        SpringApplication.run(Working620Application.class, args);

    }

}
