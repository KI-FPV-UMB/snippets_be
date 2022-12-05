package com.example.rabbitmq.worker;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WorkerApplication  implements CommandLineRunner {
    public static String APP_NAME = "";

    public static void main(String[] args) {
        APP_NAME = args[0];
        System.out.printf("Started with " + APP_NAME);
        SpringApplication.run(WorkerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Thread.currentThread().join();
    }

    // ----- CONFIGURATION -----
    private String queueName = "DEMO-QUEUE";

    @Bean
    public Queue queue() {
        return new Queue(queueName);
    }
}
