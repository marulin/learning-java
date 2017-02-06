package com.xianglesong.guice.singleton.provider;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class SingletonProviderTest {

  @Test
  public void testSingletonProvider() {
    Injector injector = Guice.createInjector(new AnimalModule2());
    Animal cat_A = injector.getInstance(Animal.class);
    System.out.println(cat_A);
    Animal cat_B = injector.getInstance(Animal.class);
    System.out.println(cat_B);
  }
}
