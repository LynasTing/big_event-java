package com.lynas.mapper;

import com.lynas.domain.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

  /**
   * 更新用户信息
   */
  @Update("update user set username=#{username}, email=#{email}, update_time=#{updateTime} where id = #{id}")
  void putUserInfo(User user);

  /**
   * 更新用户头像
   * @param url
   * @param id
   */
  @Update("update user set user_pic=#{url}, update_time=now() where id = #{id}")
  void putUserAvatar(String url, Integer id);

  /**
   * 更新用户密码
   * @param newPwd
   * @param id
   */
  @Update("update user set password=#{newPwd} where id = #{id}")
  void putUserPwd(String newPwd, Integer id);
}
