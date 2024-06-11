package com.lynas.interceptors;

import com.lynas.domain.entity.User;
import com.lynas.service.UserService;
import com.lynas.utils.JwtUtil;
import com.lynas.utils.ThreadLocalUtil;
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

  private UserService userService;
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String token = request.getHeader("Authorization");
    /**
     * 验证token
     */
    try {
      Map<String, Object> claims = JwtUtil.parseToken(token);
      ThreadLocalUtil.set(claims);
      // 放行
      return true;
    } catch (Exception e) {
      response.setStatus(401);
      return false;
    }
  }

  /**
   * 请求完成后清楚当前数据
   */
  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    ThreadLocalUtil.remove();
  }
}
