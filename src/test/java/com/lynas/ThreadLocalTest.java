package com.lynas;

import org.junit.jupiter.api.Test;

public class ThreadLocalTest {

  @Test
  public void TreadLocalSetAndGet() {
    ThreadLocal tl = new ThreadLocal();

    /**
     * 参数1 线程任务， 参数2 线程名字
     */
    new Thread(() -> {
      tl.set("张无忌");
      System.out.println(Thread.currentThread().getName() + "：" + tl.get());
      System.out.println(Thread.currentThread().getName() + "：" + tl.get());
      System.out.println(Thread.currentThread().getName() + "：" + tl.get());
    }, "蓝色").start();

    new Thread(() -> {
      tl.set("宋青书");
      System.out.println(Thread.currentThread().getName() + "：" + tl.get());
      System.out.println(Thread.currentThread().getName() + "：" + tl.get());
      System.out.println(Thread.currentThread().getName() + "：" + tl.get());
    }, "绿色").start();
  }
}
