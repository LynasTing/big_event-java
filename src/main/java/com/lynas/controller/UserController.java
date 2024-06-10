package com.lynas.controller;

import com.lynas.domain.entity.R;
import com.lynas.domain.entity.User;
import com.lynas.service.UserService;
import com.lynas.utils.JwtUtil;
import com.lynas.utils.Md5Util;
import com.lynas.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

  @Autowired
  private UserService userService;

  /**
   * 注册
   */
  @PostMapping("/register")
  public R userRegister(@Pattern(regexp = "^\\S{5,16}") String username, @Pattern(regexp = "^\\S{5,16}") String password) {
    User user = userService.findByUsername(username);
    if(Objects.isNull(user)) {
      userService.register(username, password);
      return R.success(user);
    }else {
      return R.error("用户名已被使用");
    }
  }

  /**
   * 登录
   */
  @PostMapping("/login")
  public R userLogin(@Pattern(regexp = "^\\S{5,16}") String username, @Pattern(regexp = "^\\S{5,16}") String password) {
    // 判断用户是否存在
    User loginUser = userService.findByUsername(username);
    if(loginUser == null) {
      return R.error("用户不存在");
    }
    // 校验密码
    if (Md5Util.getMD5String(password).equals(loginUser.getPassword())) {
      Map<String, Object> claims = new HashMap<>();
      claims.put("username", loginUser.getUsername());
      claims.put("password", loginUser.getPassword());
      return R.success(JwtUtil.createToken(claims));
    } else {
      return R.error("密码错误");
    }
  }

  /**
   * 用户信息
   */
  @GetMapping("/info")
  public R<User> userInfo(@RequestHeader(name = "Authorization") String token) {
  //   Map<String, Object> claims = JwtUtil.parseToken(token);
  //   String username = (String) claims.get("username");
    Map<String, Object> map = ThreadLocalUtil.get();
    String username = (String) map.get("username");
    User user = userService.findByUsername(username);
    return R.success(user);
  }

  /**
   * 更新用户信息
   */
  @PutMapping("put")
  public R putUserInfo(@RequestBody @Validated User user) {
    return userService.putUserInfo(user);
  }
}
