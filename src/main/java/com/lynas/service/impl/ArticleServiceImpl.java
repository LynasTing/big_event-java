package com.lynas.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lynas.domain.entity.Article;
import com.lynas.domain.entity.PageVo;
import com.lynas.domain.entity.R;
import com.lynas.mapper.ArticleMapper;
import com.lynas.service.ArticleService;
import com.lynas.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

  /**
   * 分页查询文章
   * @param pageNum
   * @param pageSize
   * @param categoryId
   * @param state
   * @return
   */
  @Override
  public R<PageVo> articlePge(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
    // 1. 创建PageVo对象
    PageVo<Article> pv = new PageVo<>();

    // 2. 开启分页查询
    PageHelper.startPage(pageNum, pageSize);

    // 3. 调用mapper
    // 3.1 只允许用户操作和查询自己发表的文章
    Map<String, Object> claims = ThreadLocalUtil.get();
    Integer userId = Integer.parseInt((String) claims.get("id"));
    List<Article> as = am.articlePge(userId, categoryId, state);
    // 4.需要把查询内容强转成Page类型
    PageInfo<Article> result = new PageInfo<>(as);

    // 5. 拿到数据
    pv.setTotal(result.getTotal());
    pv.setResult(result.getList());
    return R.success(pv);
  }
}
