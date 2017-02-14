package com.xianglesong.rabbitmq.config;

import java.io.UnsupportedEncodingException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExampleAmqpConfiguration {

  @Bean
  public SimpleMessageListenerContainer messageListenerContainer() {
    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
    container.setConnectionFactory(rabbitConnectionFactory());
    container.setQueueNames("task_queue");
    container.setMessageListener(exampleListener());
    return container;
  }

  @Bean
  public ConnectionFactory rabbitConnectionFactory() {
    CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
    connectionFactory.setUsername("guest");
    connectionFactory.setPassword("guest");
    return connectionFactory;
  }

  @Bean
  public MessageListener exampleListener() {
    return new MessageListener() {
      public void onMessage(Message message) {
        System.out.println("received: " + message);
        System.out.println("data: " + message.getBody().toString());

        try {
          String receiveMsg = new String(message.getBody(), "utf-8");
          System.out.println("receiveMsg: " + receiveMsg);
        } catch (UnsupportedEncodingException e) {
          e.printStackTrace();
        }
      }
    };
  }
}
