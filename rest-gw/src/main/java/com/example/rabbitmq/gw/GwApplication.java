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
    private RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(GwApplication.class, args);
    }

    @PostMapping("/send")
    public void send(@RequestBody String name) {
        System.out.println("/send " + name);
        rabbitTemplate.convertAndSend(queue.getName(), name);
    }

    @PostMapping("/send-reply")
    public String sendReply(@RequestBody String name) {
        System.out.println("/send-reply " + name);
        return "OK";
    }
    @PostMapping("/send-worker")
    public void sendWorker(@RequestBody String name) {
        System.out.println("/send-worker " + name);
    }

}
