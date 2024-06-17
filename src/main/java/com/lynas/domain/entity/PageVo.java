package com.lynas.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageVo<T> {
  /**
   * 总条数
   */
  private Long total;

  /**
   * 列表
   */
  private List<T> result;
}
