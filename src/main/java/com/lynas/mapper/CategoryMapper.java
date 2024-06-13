package com.lynas.mapper;

import com.lynas.domain.entity.Category;
import com.lynas.domain.entity.R;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {
  @Insert("insert into category(category_name, category_alias, create_user, create_time, update_time)" +
  "values(#{categoryName}, #{categoryAlias}, #{createUser}, #{createTime}, #{updateTime})")
  void articleAdd(Category category);

  @Select("select * from category where create_user = #{id}")
  List<Category> categoryPage(Integer id);

  @Select("select * from category as c where c.id = #{id}")
  Category categoryDetail(Integer id);
}
