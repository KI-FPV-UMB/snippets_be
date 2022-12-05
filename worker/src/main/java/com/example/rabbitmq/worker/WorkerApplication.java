package com.example.rabbitmq.worker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkerApplication {
    public static String APP_NAME = "";

    public static void main(String[] args) throws Exception {
        APP_NAME = args[0];

        System.out.printf("Started with " + APP_NAME);
        SpringApplication.run(WorkerApplication.class, args);

        new Subscriber().subscribe();
    }
}
