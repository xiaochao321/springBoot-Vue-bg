package com.yuanjun.mybatis.service;

import com.yuanjun.mybatis.entity.Tag;
import com.yuanjun.mybatis.vo.TagVO;

import java.util.List;


/**
 * @author shimh
 * <p>
 * 2018年1月25日
 */
public interface TagService {

    List<Tag> findAll();

    Tag getTagById(Integer id);

    Tag getTagByFirstId(Integer id);

	Tag getTagBySecondId(Integer id);

    Integer saveTag(Tag tag);

    Integer updateTag(Tag tag);

    void deleteTagById(Integer id);

    List<Tag> listHotTags(int limit);

    List<TagVO> findAllDetail();

    TagVO getTagDetail(Integer tagId);

}
