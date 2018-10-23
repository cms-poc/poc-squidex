package com.example.cms.poc.squidex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SquidexApplication {
    public static void main(String[] args) {
        SpringApplication.run(SquidexApplication.class, args);
    }
}
