package com.xianglesong.guice.bind.instance;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class InstanceTest {

  @Test
  public void testInstance() {
    Injector injector = Guice.createInjector(new ConfigureModule());
    Configure configure = injector.getInstance(Configure.class);
    System.out.println(configure);
  }
}
