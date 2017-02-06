package com.xianglesong.guice.bind.provides;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ProvideTest {

  @Test
  public void testProvides() {
    Injector injector = Guice.createInjector(new ConfigureModule());
    Configure configure = injector.getInstance(Configure.class);
    System.out.println(configure);
  }
}
