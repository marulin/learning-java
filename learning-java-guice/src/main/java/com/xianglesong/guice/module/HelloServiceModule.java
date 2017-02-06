package com.xianglesong.guice.module;

import com.google.inject.AbstractModule;
import com.xianglesong.guice.service.HelloService;
import com.xianglesong.guice.service.impl.HelloServiceImpl;
import com.xianglesong.guice.service.impl.SubHelloServiceImpl;

public class HelloServiceModule extends AbstractModule {

  @Override
  protected void configure() {
    // bind(HelloService.class).to(HelloServiceImpl.class);
    bind(HelloService.class).to(SubHelloServiceImpl.class);
  }

}
