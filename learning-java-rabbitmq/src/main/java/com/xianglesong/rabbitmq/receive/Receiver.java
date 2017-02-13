package com.xianglesong.rabbitmq.receive;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver implements MessageListener {

  @Override
  public void onMessage(Message message) {
    System.out.println("xxx =================");
    System.out.println(message);
    System.out.println("m:" + new String(message.getBody()));
    System.out.println("=================");
  }
}
