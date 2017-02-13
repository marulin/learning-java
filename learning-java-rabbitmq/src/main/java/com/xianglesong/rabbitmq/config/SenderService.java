package com.xianglesong.rabbitmq.config;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SenderService {

  @Autowired
  private RabbitMessagingTemplate rabbitMessagingTemplate;

  public void sendFoo2Rabbitmq(final Foo foo) {
    this.rabbitMessagingTemplate.convertAndSend("exchange", "queue.foo", foo);
  }

  public void sendBar2Rabbitmq(final Bar bar) {
    this.rabbitMessagingTemplate.convertAndSend("exchange", "queue.bar", bar);
  }
}
