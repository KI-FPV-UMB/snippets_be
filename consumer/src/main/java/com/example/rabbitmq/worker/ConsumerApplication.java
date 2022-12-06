package com.example.rabbitmq.worker;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumerApplication {
    public static String APP_NAME = "DEFAULT-WORKER-NAME";

    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            APP_NAME = args[0];
        } else {
            System.out.println("You have not provided worker name. " + APP_NAME + " is used. In case you want to customize the worker name, specify worker name as an application parameter in command line.");
        }

        System.out.printf("Started with " + APP_NAME);
        SpringApplication.run(ConsumerApplication.class, args);

        new Subscriber().subscribe();
    }

    // ----- Configuration -----
    private String queueName = "DEMO-QUEUE";

    @Bean
    public Queue queue() {
        return new Queue(queueName);
    }

}
