package com.xianglesong.rabbitmq.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverService {

    @RabbitListener(queues = "queue.foo")
    public void receiveFooQueue(Foo foo) {
        System.out.println("Received Foo<" + foo.getName() + ">");
    }

    @RabbitListener(queues = "queue.bar")
    public void receiveBarQueue(Bar bar) {
        System.out.println("Received Bar<" + bar.getAge() + ">");
    }
}