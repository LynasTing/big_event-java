package com.lynas.anno.article;

import com.lynas.validation.article.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented // 元注解，标识State的注解是可以抽取到帮助文档中
@Target({ElementType.FIELD}) // 元注解, 标识State将来可以用在哪些地方(类、属性、方法、参数...)
@Retention(RetentionPolicy.RUNTIME) // 元注解, 标识State用在哪个阶段(源码、编译、运行)
@Constraint(validatedBy = {StateValidation.class}) // 定义谁给这个注解来提供校验的规则
public @interface State {
  /**
   * 校验失败后的提示信息
   */
  String message() default "state的值只能是已发布或草稿";

  /**
   * 指定分组
   */
  Class<?>[] groups() default {};

  /**
   * 负载，用来获取到State注解的附加信息
   */
  Class<? extends Payload>[] payload() default {};
}
