package com.xianglesong.guice.singleton;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class SingletonTest {

  @Test
  public void testSingleton() {
    Injector injector = Guice.createInjector(new AnimalModule());

    CatWrapper wrapper1 = injector.getInstance(CatWrapper.class);
    System.out.println(wrapper1);
    System.out.println(wrapper1.getAnimal());

    CatWrapper wrapper2 = injector.getInstance(CatWrapper.class);
    System.out.println(wrapper2);
    System.out.println(wrapper2.getAnimal());
  }
}
