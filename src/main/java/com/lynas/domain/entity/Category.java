package com.lynas.domain.entity;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.groups.Default;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableName;


/**
 * (Category)表实体类
 *
 * @author LynasTing
 * @since 2024-06-03 10:20:24
 */
@TableName("category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {
    /**
     * ID
     */
    @NotEmpty(groups = put.class)
    private String id;
    /**
     * 分类名称
     */
    @NotEmpty
    private String categoryName;
    /**
     * 分类别名
     */
    @NotEmpty
    private String categoryAlias;
    /**
     * 创建人ID
     */
    private String createUser;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 没有指定校验项的属性默认属于Default分组
     * 分组之间可以相互继承
     */
    public interface add extends Default {

    }

    public interface put extends Default {

    }
}
