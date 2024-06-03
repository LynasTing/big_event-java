package com.lynas.domain.entity;

import java.util.Date;
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
    private String id;
    /**
     * 分类名称
     */
    private String categoryName;
    /**
     * 分类别名
     */
    private String categoryAlias;
    /**
     * 创建人ID
     */
    private String createUser;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;

}
