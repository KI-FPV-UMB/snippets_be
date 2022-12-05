package com.example.rabbitmq.worker;

import org.springframework.stereotype.Component;

@Component
public class Receiver {
    public void receiveMessage(String message) {
        System.out.println(WorkerApplication.APP_NAME + " received message: " + message);
    }
}