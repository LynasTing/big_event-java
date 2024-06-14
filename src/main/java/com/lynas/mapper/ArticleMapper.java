package com.lynas.mapper;

import com.lynas.domain.entity.Article;
import com.lynas.domain.entity.R;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {
  @Insert("insert into article(title, content, cover_img, state, category_id, create_user, create_time, update_time)" +
  "values (#{title}, #{content}, #{coverImg}, #{state}, #{categoryId}, #{createUser}, now(), now())")
  void articleAdd(Article article);
}
