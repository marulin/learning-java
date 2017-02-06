package com.xianglesong.guice.provider;

import com.google.inject.AbstractModule;

public class AnimalModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(String.class).toInstance("Tom");
    bind(Animal.class).toProvider(AnimalProvider.class);
    System.out.println("run configure");
  }
}
