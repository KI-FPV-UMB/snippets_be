package com.example.rabbitmq.worker;

import org.springframework.stereotype.Component;

@Component
public class Receiver {
    private int counter  = 0;
    public void receiveMessage(String message) {
        System.out.println(WorkerApplication.APP_NAME + " received message #" + counter++ +": " + message);
    }
}