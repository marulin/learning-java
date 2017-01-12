package com.xianglesong;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

  public static void main(String[] args) {
    int size = 1000000;

    String[] key = new String[size];

    // HashMap插入
    Map<String, String> map = new ConcurrentHashMap<String, String>(10000000);

    long start = System.currentTimeMillis();

    for (int i = 0; i < size; i++) {
      key[i] = UUID.randomUUID().toString();
      map.put(key[i], UUID.randomUUID().toString());
    }

    long end = System.currentTimeMillis();

    System.out.println(end - start);
    start = System.currentTimeMillis();
    for (int i = 0; i < size; i++) {
      map.get(key[i]);
    }
    end = System.currentTimeMillis();
    System.out.println(end - start);
  }

}
