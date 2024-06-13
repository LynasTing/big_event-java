package com.lynas.controller;

import com.lynas.domain.entity.Category;
import com.lynas.domain.entity.R;
import com.lynas.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
  @Autowired
  private CategoryService cs;

  @PostMapping("/add")
  public R categoryAdd(@RequestBody @Validated Category category) {
    return cs.categoryAdd(category);
  }

  @GetMapping("/page")
  public R<List<Category>> categoryPage() {
    return R.success(cs.categoryPage());
  }

  @GetMapping("detail")
  public R categoryDetail(@RequestParam("id") Integer id) {
    return cs.categoryDetail(id);
  }


}
