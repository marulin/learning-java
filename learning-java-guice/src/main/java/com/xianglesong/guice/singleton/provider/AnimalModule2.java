package com.xianglesong.guice.singleton.provider;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class AnimalModule2 extends AbstractModule {

  @Override
  protected void configure() {
    bind(Animal.class).in(Singleton.class);
    System.out.println("run AnimalModule.configure()");
  }
}
