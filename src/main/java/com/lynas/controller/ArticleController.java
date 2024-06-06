package com.lynas.controller;

import com.lynas.domain.entity.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {

  @GetMapping("list")
  public R<String> list() {
    return R.success("文章列表");
  }
}
