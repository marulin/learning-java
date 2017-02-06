package com.xianglesong.guice.singleton;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.name.Names;

public class AnimalModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(Animal.class).annotatedWith(Names.named("Tom")).to(Animal.class).in(Singleton.class);
    System.out.println("run AnimalModule.configure()");
  }
}
