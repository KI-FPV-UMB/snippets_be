package com.example.rabbitmq.gw;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.stereotype.Component;

@Component
public class Publisher {
    public void sendMessage(String message) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.exchangeDeclare("DEMO_EXCHANGE", BuiltinExchangeType.FANOUT);

            channel.basicPublish("DEMO_EXCHANGE", "", null, message.getBytes("UTF-8"));
            System.out.println(" Sent message: " + message);
        }
    }
}
