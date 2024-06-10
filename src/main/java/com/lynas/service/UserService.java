package com.lynas.service;

import com.lynas.domain.entity.R;
import com.lynas.domain.entity.User;

public interface UserService {
  User findByUsername(String username);

  void register(String username, String password);

  R putUserInfo(User user);
}
