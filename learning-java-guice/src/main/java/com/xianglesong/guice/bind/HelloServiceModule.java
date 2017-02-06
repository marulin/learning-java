package com.xianglesong.guice.bind;

import com.google.inject.AbstractModule;

public class HelloServiceModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(Animal.class).annotatedWith(Tom.class).to(Cat.class);
    bind(Animal.class).to(Dog.class);
    bind(HelloService.class).to(HelloServiceImpl.class);
  }

}
