package com.xianglesong.guice.provider;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ProviderTest {

  @Test
  public void testProvider() {
    Injector injector = Guice.createInjector(new AnimalModule());
    AnimalProvider provider = injector.getInstance(AnimalProvider.class);
    Animal cat = provider.get();
    System.out.println(cat);
    cat.say();
  }
}
