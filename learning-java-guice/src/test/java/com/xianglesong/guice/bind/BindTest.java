package com.xianglesong.guice.bind;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class BindTest {

  @Test
  public void testBind() {
    Injector injector = Guice.createInjector(new HelloServiceModule());
    HelloService helloService = injector.getInstance(HelloService.class);
    helloService.sayHello();
  }

  @Test
  public void testBind2() {
    Injector injector = Guice.createInjector(new HelloServiceModule2());
    HelloService helloService = injector.getInstance(HelloService.class);
    helloService.sayHello();
  }
}
