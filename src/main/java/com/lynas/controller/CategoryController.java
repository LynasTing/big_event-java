package com.lynas.controller;

import com.lynas.domain.entity.Category;
import com.lynas.domain.entity.R;
import com.lynas.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
  @Autowired
  private CategoryService cs;

  @PostMapping("/add")
  public R articleAdd(@RequestBody @Validated Category category) {
    return cs.articleAdd(category);
  }
}
