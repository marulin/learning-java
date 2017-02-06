package com.xianglesong.guice.bind;

import com.google.inject.Inject;

public class HelloServiceImpl implements HelloService {

  Animal animal;

  @Inject
  public HelloServiceImpl(@Tom Animal animal) {
    this.animal = animal;
  }

  @Override
  public void sayHello() {
    System.out.println(animal.getClass().getSimpleName());
    animal.say();
  }
}
