package com.xianglesong.rabbitmq.receive;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@Primary
public class RabbitMQConfiguration {

  final static String TEST_QUEUE_NAME = "queue.bar";
  // final static String TEST_EXCHANGE_NAME = "test_exchange";
  // final static String ROUTING_KEY = "test";

  // RabbitMQ的配置信息
  @Value("${spring.rabbitmq.host}")
  private String mqRabbitHost;
  @Value("${spring.rabbitmq.port}")
  private Integer mqRabbitPort;
  @Value("${spring.rabbitmq.username}")
  private String mqRabbitUsername;
  @Value("${spring.rabbitmq.password}")
  private String mqRabbitPassword;

  // @Value("${mq.rabbit.virtualHost}")
  // private String mqRabbitVirtualHost;

  // 建立一个连接容器，类型数据库的连接池。
  @Bean
  public ConnectionFactory connectionFactory() {
    CachingConnectionFactory connectionFactory =
        new CachingConnectionFactory(mqRabbitHost, mqRabbitPort);

    connectionFactory.setUsername(mqRabbitUsername);
    connectionFactory.setPassword(mqRabbitPassword);
    // connectionFactory.setVirtualHost(mqRabbitVirtualHost);

    return connectionFactory;
  }

  @Bean
  public AmqpAdmin amqpAdmin(ConnectionFactory connectionFactory) {
    return new RabbitAdmin(connectionFactory);
  }

  // RabbitMQ的使用入口
  @Bean
  public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
    return new RabbitTemplate(connectionFactory);
  }

  // 要求RabbitMQ建立一个队列。
  @Bean
  public Queue myQueue() {
    return new Queue(TEST_QUEUE_NAME);
  }

  // 声明一个监听容器
  @Bean
  SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
      Receiver listenerAdapter) {

    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
    container.setConnectionFactory(connectionFactory);
    container.setQueueNames(new String[] {TEST_QUEUE_NAME});
    container.setMessageListener(listenerAdapter);

    return container;
  }

  // 在spring容器中添加一个监听类
  @Bean
  Receiver receiver() {
    return new Receiver();
  }

  // 定义一个直连交换机
  // @Bean
  // DirectExchange exchange() {
  // return new DirectExchange(TEST_EXCHANGE_NAME);
  // }

  // 要求队列和直连交换机绑定，指定ROUTING_KEY
  // @Bean
  // Binding binding(Queue queue, DirectExchange exchange) {
  // return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
  // }

}
