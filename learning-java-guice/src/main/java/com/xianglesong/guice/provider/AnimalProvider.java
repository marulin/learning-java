package com.xianglesong.guice.provider;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class AnimalProvider implements Provider<Animal> {

  String name;

  @Inject
  public AnimalProvider(String name) {
    this.name = name;
  }

  public Animal get() {
    Cat cat = new Cat();
    cat.setName(name);
    System.out.println("run Provider.get()");
    return cat;
  }
}
