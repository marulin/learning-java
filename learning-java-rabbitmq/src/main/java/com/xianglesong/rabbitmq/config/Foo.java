package com.xianglesong.rabbitmq.config;

public class Foo {

  private String name;

  public Foo(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Foo [name=" + name + "]";
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

}
