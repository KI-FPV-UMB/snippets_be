package com.example.rabbitmq.worker;

import com.rabbitmq.client.*;

public class Subscriber {
    public void subscribe() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("DEMO_EXCHANGE", BuiltinExchangeType.FANOUT);
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, "DEMO_EXCHANGE", "");

        System.out.println("Waiting for messages ...");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println("Received: " + message );
        };

        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {});
    }
}
