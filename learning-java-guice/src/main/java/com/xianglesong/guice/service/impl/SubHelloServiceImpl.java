package com.xianglesong.guice.service.impl;

import com.xianglesong.guice.service.HelloService;

public class SubHelloServiceImpl implements HelloService  {

  @Override
  public void sayHello() {
    System.out.println("Sub Hello");
  }
}
