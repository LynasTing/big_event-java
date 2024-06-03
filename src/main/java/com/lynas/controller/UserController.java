package com.lynas.controller;

import com.lynas.domain.entity.R;
import com.lynas.domain.entity.User;
import com.lynas.service.UserService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

  @Autowired
  private UserService userService;

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
}
