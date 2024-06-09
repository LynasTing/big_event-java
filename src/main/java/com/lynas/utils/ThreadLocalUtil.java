package com.lynas.utils;

public class ThreadLocalUtil {
  // 提供一个ThreadLocal对象
  private static final ThreadLocal THREAD_LOCAL = new ThreadLocal();

  // 存储键值对
  public static void set(Object v) {
    THREAD_LOCAL.set(v);
  }

  // 根据键名获取值
  public static <T> T get() {
    return (T) THREAD_LOCAL.get();
  }

  // 清除ThreadLocal，防止内存泄漏
  public static void remove() {
    THREAD_LOCAL.remove();
  }
}
