package com.xianglesong.guice.service.impl;

import com.xianglesong.guice.service.HelloService;

public class HelloServiceImpl implements HelloService {

  @Override
  public void sayHello() {
    System.out.println("hello");
  }
}
