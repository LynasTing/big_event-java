package com.lynas.controller;

import com.lynas.domain.entity.Category;
import com.lynas.domain.entity.R;
import com.lynas.service.ArticleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {
  private ArticleService articleService;

  @GetMapping("list")
  public R<String> list() {
    return R.success("文章列表");
  }


}
