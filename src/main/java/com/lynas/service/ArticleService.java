package com.lynas.service;

import com.lynas.domain.entity.Article;
import com.lynas.domain.entity.PageVo;
import com.lynas.domain.entity.R;

public interface ArticleService {
  R articleAdd(Article article);

  R<PageVo> articlePge(Integer pageNum, Integer pageSize, Integer categoryId, String state);
}
