package com.xianglesong.basic;

import java.util.ArrayList;
import java.util.List;

public class ListContains {

  public static void main(String[] args) {
    List<Person> list = new ArrayList<Person>();
    list.add(new Person("1", 1));
    list.add(new Person("2", 2));
    list.add(new Person("3", 3));

    System.out.println(list.contains(new Person("1", 1)));
    System.out.println(list.contains(new Person("2", 1)));
    System.out.println(list.contains(new Person("3", 3)));
  }

}


class Person {
  String id;
  int age;
  String address;

  public String getId() {
    return id;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Person() {}

  public Person(String id, int age) {
    this.id = id;
    this.age = age;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + age;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Person other = (Person) obj;
    if (age != other.age)
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
