package com.lynas.domain.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;
import com.lynas.anno.article.State;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableName;
import org.hibernate.validator.constraints.URL;

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
    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")
    private String title;
    /**
     * 文章内容
     */
    @NotEmpty
    private String content;
    /**
     * 文章封面
     */
    @NotEmpty
    @URL
    @TableField("cover_img")
    private String coverImg;
    /**
     * 文章状态: 只能是[已发布] 或者 [草稿]
     */
    @State
    private String state;
    /**
     * 文章分类ID
     */
    @NotNull
    private String categoryId;
    /**
     * 创建人ID
     */
    private String createUser;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

}
