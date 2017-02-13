package com.xianglesong.rabbitmq.config;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.xianglesong.rabbitmq")
public class RabbitmqdemoApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(RabbitmqdemoApplication.class, args);
  }

  @Autowired
  SenderService senderService;

  @Override
  public void run(String... strings) throws Exception {
    Random random = new Random();
    int i = 0;
    while (true) {
      if (i++ > 10)
        break;
      System.out.println("send: " + i);
      senderService.sendFoo2Rabbitmq(new Foo(UUID.randomUUID().toString()));
      // senderService.sendBar2Rabbitmq(new Bar(random.nextInt()));
      // senderService.sendFoo2Rabbitmq(new Foo(UUID.randomUUID().toString()));
    }
  }
}
