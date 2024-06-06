package com.lynas.interceptors;

import com.lynas.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

/**
 * 拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String token = request.getHeader("Authorization");
    /**
     * 验证token
     */
    try {
      Map<String, Object> claims = JwtUtils.parseToken(token);
      // 放行
      return true;
    } catch (Exception e) {
      response.setStatus(401);
      return false;
    }
  }
}
