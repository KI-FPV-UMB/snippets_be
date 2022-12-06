package com.example.rabbitmq.worker;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Worker {
    private int counter  = 0;
    @RabbitListener(queues = "DEMO-QUEUE")
    public void receiveMessage(String message) {
        System.out.println(ConsumerApplication.APP_NAME + " received message #" + counter++ +": " + message);
    }
}