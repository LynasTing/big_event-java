package com.lynas.mapper;

import com.lynas.domain.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
  /**
   * 根据用户名查询用户
   * @param username
   */
  @Select("select * from user where username=#{username}")
  User findByUsername(String username);

  /**
   * 新用户注册
   * @param username 用户名
   * @param password 密码
   */
  @Insert("insert into user(username, password, create_time, update_time)" +
    " values(#{username}, #{password}, now(), now())")
  void register(String username, String password);
}
