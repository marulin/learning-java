package com.xianglesong.guice.bind.instance;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class ConfigureModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(String.class).annotatedWith(Names.named("JDBC URL")).toInstance(
        "jdbc:mysql://localhost/pizza");
    bind(Integer.class).annotatedWith(Names.named("login timeout seconds")).toInstance(10);
  }

}
