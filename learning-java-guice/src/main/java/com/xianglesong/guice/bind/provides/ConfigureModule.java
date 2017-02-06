package com.xianglesong.guice.bind.provides;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;

public class ConfigureModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(String.class).annotatedWith(Names.named("JDBC URL")).toInstance(
        "jdbc:mysql://localhost/pizza");
  }

  @Provides
  int getLoginTimeout() {
    System.out.println("run @Provides");
    return 20;
  }
}
