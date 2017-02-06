package com.xianglesong.guice.bind;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class HelloServiceModule2 extends AbstractModule {

  @Override
  protected void configure() {
    bind(Animal.class).annotatedWith(Names.named("Snoopy")).to(Dog.class);
    bind(Animal.class).to(Cat.class);
    bind(HelloService.class).to(HelloServiceImpl2.class);
  }

}
