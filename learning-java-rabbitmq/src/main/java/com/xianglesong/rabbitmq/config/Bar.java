package com.xianglesong.rabbitmq.config;

public class Bar {

  private int age;

  public Bar(int age) {
    this.age = age;
  }

  public int getAge() {
    return this.age;
  }

  @Override
  public String toString() {
    return "Bar [age=" + age + "]";
  }

  public void setAge(int age) {
    this.age = age;
  }

}
