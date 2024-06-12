package com.lynas.service;

import com.lynas.domain.entity.Category;
import com.lynas.domain.entity.R;

public interface ArticleService {
  R articleAdd(Category category);
}
