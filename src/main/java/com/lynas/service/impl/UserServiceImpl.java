package com.lynas.service.impl;

import com.lynas.domain.entity.R;
import com.lynas.domain.entity.User;
import com.lynas.mapper.UserMapper;
import com.lynas.service.UserService;
import com.lynas.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserMapper userMapper;

  @Override
  public User findByUsername(String username) {
    return userMapper.findByUsername(username);
  }

  @Override
  public void register(String username, String password) {
    /**
     * 对密码进行md5加密
     */
    String s = Md5Util.getMD5String(password);
    /**
     * 注册
     */
    userMapper.register(username, s);
  }

  @Override
  public R putUserInfo(User user) {
    try {
      user.setUpdateTime(LocalDateTime.now());
      userMapper.putUserInfo(user);
      return R.success();
    } catch (RuntimeException e) {
      return R.error(e.getMessage());
    }
  }
}
