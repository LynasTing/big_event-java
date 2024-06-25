package com.lynas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

@SpringBootTest // 如果测试类上添加了这个注解,单元测试方法执行前会先初始化Spring容器
public class RedisTest {

  @Autowired
  private StringRedisTemplate redisTemplate;

  @Test
  public void RedisSet() {
    ValueOperations<String, String> operations = redisTemplate.opsForValue();
    operations.set("username", "LynasTing");
    operations.set("id", "xxxx", 15, TimeUnit.SECONDS);
  }

  @Test
  public void RedisGet() {
    ValueOperations<String, String> operations = redisTemplate.opsForValue();
    System.out.println(operations.get("username"));
  }
}
