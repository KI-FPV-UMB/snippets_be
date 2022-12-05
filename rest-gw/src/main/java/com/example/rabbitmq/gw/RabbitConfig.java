package com.example.rabbitmq.gw;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class RabbitConfig {
    private String queueName = "DEMO-QUEUE";

    @Bean
    public Queue queue() {
        return new Queue(queueName);
    }

}
