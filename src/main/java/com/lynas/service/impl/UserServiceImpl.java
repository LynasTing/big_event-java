package com.lynas.service.impl;

import com.lynas.domain.entity.R;
import com.lynas.domain.entity.User;
import com.lynas.mapper.UserMapper;
import com.lynas.service.UserService;
import com.lynas.utils.Md5Util;
import com.lynas.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

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

  /**
   * 更新用户头像
   * @param url
   */
  @Override
  public R putUserAvatar(String url) {
    try {
      Map<String, Object> map = ThreadLocalUtil.get();
      Integer id = Integer.parseInt((String) map.get("id"));
      userMapper.putUserAvatar(url, id);
      return R.success();
    } catch (RuntimeException e) {
      return R.error(e.getMessage());
    }
  }

  /**
   * 更新用户密码
   * @param newPwd
   */
  @Override
  public R putUserPwd(String newPwd) {
    try {
      Map<String, Object> map = ThreadLocalUtil.get();
      Integer id = Integer.parseInt((String) map.get("id"));
      userMapper.putUserPwd(Md5Util.getMD5String(newPwd), id);
      return R.success();
    }catch (RuntimeException e) {
      return R.error(e.getMessage());
    }
  }
}
