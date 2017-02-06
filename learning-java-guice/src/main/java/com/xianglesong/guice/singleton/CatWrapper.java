package com.xianglesong.guice.singleton;

import javax.inject.Named;
import com.google.inject.Inject;

public class CatWrapper {

  Animal animal;

  @Inject
  private CatWrapper(@Named("Tom") Animal animal) {
    System.out.println("CatWrapper.Contructor()");
    this.animal = animal;
  }

  public void say() {
    animal.say();
  }

  public Animal getAnimal() {
    return this.animal;
  }
}
