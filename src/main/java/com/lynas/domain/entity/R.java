package com.lynas.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 统一响应格式
@NoArgsConstructor
@AllArgsConstructor
@Data
public class R<T> {
  /**
   * 200 成功
   */
  private Integer code;

  /**
   * 提示信息
   */
  private String msg;

  /**
   * 响应内容
   */
  private T data;

  /**
   * 有返回结果
   */
  public static <K> R<K> success(K data) {
    return new R<>(200, "操作成功", data);
  }

  /**
   * 无返回结果，重载上面的success
   */
  public static R success() {
    return new R(200, "操作成功", null);
  }

  /**
   * 响应失败内容
   */
  public static R error(String msg) {
    return new R(201, msg, null);
  }
}
