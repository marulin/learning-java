package com.xianglesong.guice.service;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.xianglesong.guice.module.HelloServiceModule;

public class HelloServiceTest {

  @Test
  public void testHelloService() {
    Injector injector = Guice.createInjector(new HelloServiceModule());
    HelloService helloService = injector.getInstance(HelloService.class);
    System.out.println(helloService.getClass().getSimpleName());
    helloService.sayHello();
  }

  // @Test
  // public void testHelloServiceSub() {
  // Injector injector = Guice.createInjector(new HelloServiceModule());
  // HelloService helloService = injector.getInstance(HelloService.class);
  // System.out.println(helloService.getClass().getSimpleName());
  // helloService.sayHello();
  // }
}
