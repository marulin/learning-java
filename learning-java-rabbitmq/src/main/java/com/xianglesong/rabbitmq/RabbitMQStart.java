package com.xianglesong.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class RabbitMQStart {

  public static void main(String[] args) {
    System.out.println("begin");
    SpringApplication.run(RabbitMQStart.class, args);
    System.out.println("end.");
  }

}
