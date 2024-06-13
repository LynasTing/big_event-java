package com.lynas.service;

import com.lynas.domain.entity.Category;
import com.lynas.domain.entity.R;

import java.util.List;

public interface CategoryService {
  R categoryAdd(Category category);


  List<Category> categoryPage();

  R categoryDetail(Integer id);

  R categoryPut(Category category);
}
