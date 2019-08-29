package com.yuanjun.mybatis.repository.wrapper;

import com.yuanjun.mybatis.vo.CategoryVO;

import java.util.List;



/**
 * @author shimh
 * <p>
 * 2018年1月25日
 */
public interface CategoryWrapper {

    List<CategoryVO> findAllDetail();

    CategoryVO getCategoryDetail(Integer categoryId);
}
