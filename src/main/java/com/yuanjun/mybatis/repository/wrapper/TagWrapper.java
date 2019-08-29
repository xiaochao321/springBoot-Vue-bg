package com.yuanjun.mybatis.repository.wrapper;

import com.yuanjun.mybatis.vo.TagVO;

import java.util.List;



/**
 * @author shimh
 * <p>
 * 2018年1月25日
 */
public interface TagWrapper {

    List<TagVO> findAllDetail();

    TagVO getTagDetail(Integer tagId);
}
