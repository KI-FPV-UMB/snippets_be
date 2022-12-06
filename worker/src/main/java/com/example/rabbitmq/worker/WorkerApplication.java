package com.example.rabbitmq.worker;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WorkerApplication {
    public static String APP_NAME = "";

    public static void main(String[] args) throws Exception {
        APP_NAME = args[0];

        System.out.printf("Started with " + APP_NAME);
        SpringApplication.run(WorkerApplication.class, args);

        new Subscriber().subscribe();
    }

    // ----- Configuration -----
    private String queueName = "DEMO-QUEUE";

    @Bean
    public Queue queue() {
        return new Queue(queueName);
    }

}
