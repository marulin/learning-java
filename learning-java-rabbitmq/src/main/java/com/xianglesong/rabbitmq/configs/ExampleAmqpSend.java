package com.xianglesong.rabbitmq.configs;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ExampleAmqpSend {

  @Autowired
  RabbitTemplate amqpTemplate;

  @Scheduled(cron = "0/5 * * * * ?")
  public void sendMsg() {
    System.out.println("send msg");
    amqpTemplate.setRoutingKey("task_queue");
    amqpTemplate.setQueue("task_queue");
    amqpTemplate.convertAndSend(new String("test ag" + System.currentTimeMillis()));
    System.out.println("send msg end.");
  }
}
