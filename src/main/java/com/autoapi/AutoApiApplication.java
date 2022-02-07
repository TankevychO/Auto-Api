package com.autoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AutoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoApiApplication.class, args);
    }
}
