package com.lynas.validation.article;

import com.lynas.anno.article.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

/**
 * ConstraintValidator接收两个参数(给哪个注解提供校验规则，校验的数据类型)
 */
public class StateValidation implements ConstraintValidator<State, String> {
  /**
   * @param value 将来要校验的数据
   * @param ctx
   * @return
   */
  @Override
  public boolean isValid(String value, ConstraintValidatorContext ctx) {
    // 校验规则
    if(null == value) {
      return false;
    }
    if(value.equals("已发布") || value.equals("草稿")) {
      return true;
    }
    return false;
  }
}

