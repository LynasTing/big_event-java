package com.lynas.controller;

import com.lynas.domain.entity.R;
import com.lynas.domain.entity.User;
import com.lynas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/register")
  public R userRegister(String username, String password) {
    User user = userService.findByUsername(username);
    if(Objects.isNull(user)) {
      userService.register(username, password);
      return R.success(user);
    }else {
      return R.error("用户名已被使用");
    }
  }
}
