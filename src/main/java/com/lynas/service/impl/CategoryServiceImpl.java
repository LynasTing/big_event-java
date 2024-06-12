package com.lynas.service.impl;

import com.lynas.domain.entity.Category;
import com.lynas.domain.entity.R;
import com.lynas.mapper.CategoryMapper;
import com.lynas.service.CategoryService;
import com.lynas.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {
  @Autowired
  private CategoryMapper cm;

  /**
   * 新增分类
   *
   * @param category
   * @return
   */
  @Override
  public R categoryAdd(Category category) {
    try {
      category.setCreateTime(LocalDateTime.now());
      category.setUpdateTime(LocalDateTime.now());
      Map<String, Object> claims = ThreadLocalUtil.get();
      String id = (String) claims.get("id");
      category.setCreateUser(id);
      cm.articleAdd(category);
      return R.success();
    }catch (Exception e) {
      return R.error(e.getMessage());
    }
  }

  /**
   * 分页查询分类
   */
  @Override
  public List<Category> categoryPage() {
    Map<String, Object> claims = ThreadLocalUtil.get();
    Integer id = Integer.parseInt((String) claims.get("id"));
    System.out.println("id + " + id);
    return cm.categoryPage(id);
  }
}
