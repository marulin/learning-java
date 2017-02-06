package com.xianglesong.guice.bind;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class HelloServiceImpl2 implements HelloService {

  Animal animal;

  @Inject
  public HelloServiceImpl2(@Named("Snoopy") Animal animal) {
    this.animal = animal;
  }

  @Override
  public void sayHello() {
    System.out.println(animal.getClass().getSimpleName());
    animal.say();
  }
}
