package com.example.rabbitmq.gw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
@RestController
@SpringBootApplication
public class GwApplication {
    static final String TOPIC_EXCHANGE = "spring-boot-exchange";
    private final RabbitTemplate rabbitTemplate;

    public GwApplication(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(GwApplication.class, args);
    }

    @PostMapping("/send")
    public void send(@RequestBody String name) {
        System.out.println("/send " + name);
        rabbitTemplate.convertAndSend(TOPIC_EXCHANGE, "foo.bar.baz", name);
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
