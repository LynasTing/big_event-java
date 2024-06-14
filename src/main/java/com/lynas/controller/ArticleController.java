package com.lynas.controller;

import com.lynas.domain.entity.Article;
import com.lynas.domain.entity.Category;
import com.lynas.domain.entity.R;
import com.lynas.service.ArticleService;
import com.lynas.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
  @Autowired
  private ArticleService articleService;

  @GetMapping("list")
  public R<String> list() {
    return R.success("文章列表");
  }

  @PostMapping("/add")
  public R articleAdd(@RequestBody @Validated Article article) {
    Map<String, Object> claims = ThreadLocalUtil.get();
    String id = (String) claims.get("id");
    article.setCreateUser(id);
    articleService.articleAdd(article);
    return R.success();
  }
}
