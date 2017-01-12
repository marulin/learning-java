package com.xianglesong;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@EnableAutoConfiguration
@SpringBootApplication
public class ReidsTest implements CommandLineRunner {

  @Autowired
  StringRedisTemplate redisTemplate;

  // Redis string (or value) operations
  @Resource(name = "redisTemplate")
  private ValueOperations<String, String> valueOperationsStr;

  public static void main(String[] args) {
    SpringApplication.run(ReidsTest.class, args);
  }


  public void run(String... strings) throws Exception {
    System.out.println("begin >>>>>>>>>>>>>>>>>>>> ");
    // redisTemplate.getConnectionFactory().getConnection().set("a".getBytes(), "b".getBytes());

    int size = 100000;
    String[] key = new String[size];

    long start = System.currentTimeMillis();

    for (int i = 0; i < size; i++) {
      key[i] = UUID.randomUUID().toString();
      // map.put(key[i], UUID.randomUUID().toString());
      // redisTemplate.getConnectionFactory().getConnection()
      // .set(key[i].getBytes(), UUID.randomUUID().toString().getBytes());
      valueOperationsStr.set(key[i], UUID.randomUUID().toString());
    }

    long end = System.currentTimeMillis();

    System.out.println(end - start);
    start = System.currentTimeMillis();
    for (int i = 0; i < size; i++) {
      // map.get(key[i]);
      // redisTemplate.getConnectionFactory().getConnection().get(key[i].getBytes());
      valueOperationsStr.get(key[i]);
    }
    end = System.currentTimeMillis();
    System.out.println(end - start);

    System.out.println("end >>>>>>>>>>>>>>>>>>>> ");
  }
}
