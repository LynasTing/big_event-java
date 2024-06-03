package com.lynas.exception;

import com.lynas.domain.entity.R;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalException {

  @ExceptionHandler(Exception.class)
  public R handleException(Exception e) {
    e.printStackTrace();
    return R.error(StringUtils.hasText(e.getMessage()) ? e.getMessage() : "操作异常");
  }
}
