package com.example.rabbitmq.gw;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
@RestController
@SpringBootApplication
public class GwApplication {
    @Autowired
    private Queue queue;

    @Autowired
    private Publisher publisher;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(GwApplication.class, args);
    }

    @PostMapping("/send-worker")
    public void send(@RequestBody String message) {
        System.out.println("/send " + message);
        rabbitTemplate.convertAndSend(queue.getName(), message);
    }

    @PostMapping("/send-many")
    public void sendReply(@RequestBody String name) throws Exception {
        System.out.println("/send-reply " + name);
        publisher.sendMessage(name);
    }

}
