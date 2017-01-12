package com.xianglesong;

import com.meetup.memcached.MemcachedClient;
import com.meetup.memcached.SockIOPool;

public class MemCacheInvoke {

  protected static MemcachedClient mcc = new MemcachedClient();

  static {

    // 设置缓存服务器列表，当使用分布式缓存的时，可以指定多个缓存服务器。这里应该设置为多个不同的服务，我这里将两个服务设置为一样的，大家不要向我学习，呵呵。
    String[] servers = {"localhost:11211",};

    // 设置服务器权重
    Integer[] weights = {3, 2};

    // 创建一个Socked连接池实例
    SockIOPool pool = SockIOPool.getInstance();

    // 向连接池设置服务器和权重
    pool.setServers(servers);
    pool.setWeights(weights);

    // set some TCP settings
    // disable nagle
    // set the read timeout to 3 secs
    // and don't set a connect timeout
    pool.setNagle(false);
    pool.setSocketTO(3000);
    pool.setSocketConnectTO(0);

    // initialize the connection pool
    pool.initialize();
  }

  public static void main(String[] args) {
    mcc.set("foo", "This is a test String");
    String bar = mcc.get("foo").toString();
    System.out.println(">>> " + bar);
  }
}
