package com.lynas.service.impl;

import com.lynas.domain.entity.Article;
import com.lynas.domain.entity.R;
import com.lynas.mapper.ArticleMapper;
import com.lynas.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
  @Autowired
  private ArticleMapper am;
  /**
   * 新增文章
   */
  @Override
  public R articleAdd(Article article) {
    am.articleAdd(article);
    return R.success();
  }
}
