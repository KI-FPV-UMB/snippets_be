package com.example.rabbitmq.gw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class GwApplication {
    public static void main(String[] args) {
        SpringApplication.run(GwApplication.class, args);
    }
}
