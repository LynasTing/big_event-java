package com.lynas.domain.entity;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableName;


/**
 * 用户表(User)表实体类
 *
 * @author LynasTing
 * @since 2024-06-03 10:16:34
 */
@TableName("user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    /**
     * ID
     */
    @NotNull
    private String id;
    
    /**
     * 用户名
     */
    private String username;
    
    /**
     * 密码
     */
    @JsonIgnore // 在将对象转为JSON时忽略当前参数
    private String password;
    
    /**
     * 昵称
     */
    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")
    private String nickname;
    
    /**
     * 邮箱
     */
    @Email
    @NotEmpty
    private String email;
    
    /**
     * 头像
     */
    private String userPic;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
}
