package com.xianglesong;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class GuavaLoadingCacheTest {
  static int miss = 0;

  public static void main(String[] args) throws ExecutionException {
    int size = 1000000;

    String[] key = new String[size];

    // HashMap插入
    LoadingCache<String, String> cache = CacheBuilder.newBuilder()//
        // .refreshAfterWrite(1, TimeUnit.MINUTES)// 给定时间内没有被读/写访问，则回收。
        // .expireAfterWrite(5, TimeUnit.SECONDS)//给定时间内没有写访问，则回收。
        // .expireAfterAccess(3, TimeUnit.SECONDS)// 缓存过期时间为3秒
        .maximumSize(10000000).build(new CacheLoader<String, String>() {
          @Override
          /**  当本地缓存命没有中时，调用load方法获取结果并将结果缓存
           */
          public String load(String key) throws ExecutionException {
            // System.out.println("test");
            // System.out.println(miss++);
            miss++;
            return UUID.randomUUID().toString();
          }
        });

    // for test
    // cache.put("test", "tester");
    // System.out.println(cache.get("test"));

    long start = System.currentTimeMillis();

    for (int i = 0; i < size; i++) {
      key[i] = UUID.randomUUID().toString();
      cache.put(key[i], UUID.randomUUID().toString());
    }

    long end = System.currentTimeMillis();

    System.out.println(end - start);
    start = System.currentTimeMillis();
    for (int i = 0; i < size; i++) {
      cache.get(key[i]);
    }
    end = System.currentTimeMillis();
    System.out.println(end - start);

    System.out.println("miss: " + miss);
  }

}
