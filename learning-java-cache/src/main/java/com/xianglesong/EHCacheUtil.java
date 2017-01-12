package com.xianglesong;

import java.util.UUID;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.expiry.Expirations;

/**
 * EHCacheUtil
 *
 * @author ma.rulin
 * @date 16/11/21
 */
public class EHCacheUtil {

  public static void main(String[] args)           {
    CacheManager cacheManager =
        CacheManagerBuilder
            .newCacheManagerBuilder()
            .withCache(
                "ehcache",
                CacheConfigurationBuilder
                    .newCacheConfigurationBuilder(String.class, String.class,
                        ResourcePoolsBuilder.heap(1000000))
                    .withSizeOfMaxObjectSize(1024 * 5, MemoryUnit.MB)
                    .withExpiry(Expirations.noExpiration())).build();

    cacheManager.init();

    Cache<String, String> preConfigured =
        cacheManager.getCache("ehcache", String.class, String.class);

    int size = 1000000;

    String[] key = new String[size];

    long start = System.currentTimeMillis();

    for (int i = 0; i < size; i++) {
      key[i] = UUID.randomUUID().toString();
      // map.put(key[i], UUID.randomUUID().toString());
      preConfigured.put(key[i], UUID.randomUUID().toString());
    }

    long end = System.currentTimeMillis();

    System.out.println(end - start);
    start = System.currentTimeMillis();
    for (int i = 0; i < size; i++) {
      preConfigured.get(key[i]);
    }
    end = System.currentTimeMillis();
    System.out.println(end - start);

    cacheManager.removeCache("ehcache");

    cacheManager.close();
  }
}
