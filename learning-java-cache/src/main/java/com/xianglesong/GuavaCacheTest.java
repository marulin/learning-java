package com.xianglesong;

import java.util.UUID;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class GuavaCacheTest {

  public static void main(String[] args) {
    int size = 1000000;

    String[] key = new String[size];

    // HashMap插入
    Cache<Object, Object> cache = CacheBuilder.newBuilder()//
        // .refreshAfterWrite(1, TimeUnit.MINUTES)// 给定时间内没有被读/写访问，则回收。
        // .expireAfterWrite(5, TimeUnit.SECONDS)//给定时间内没有写访问，则回收。
        // .expireAfterAccess(3, TimeUnit.SECONDS)// 缓存过期时间为3秒
        .maximumSize(10000000).build();

    long start = System.currentTimeMillis();

    for (int i = 0; i < size; i++) {
      key[i] = UUID.randomUUID().toString();
      cache.put(key[i], UUID.randomUUID().toString());
    }

    long end = System.currentTimeMillis();

    System.out.println(end - start);
    start = System.currentTimeMillis();
    for (int i = 0; i < size; i++) {
      cache.getIfPresent(key[i]);
    }
    end = System.currentTimeMillis();
    System.out.println(end - start);
  }

}
