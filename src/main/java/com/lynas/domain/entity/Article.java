package com.lynas.domain.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableName;


/**
 * (Article)表实体类
 *
 * @author LynasTing
 * @since 2024-06-03 10:19:58
 */
@TableName("article")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Serializable {
    /**
     * ID
     */
    private String id;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 文章内容
     */
    private String content;
    /**
     * 文章封面
     */
    private String coverImg;
    /**
     * 文章状态: 只能是[已发布] 或者 [草稿]
     */
    private String state;
    /**
     * 文章分类ID
     */
    private String categoryId;
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
