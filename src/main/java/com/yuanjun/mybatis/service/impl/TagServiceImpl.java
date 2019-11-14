package com.yuanjun.mybatis.service.impl;

import java.util.List;


import com.yuanjun.mybatis.annotation.CurDataSource;
import com.yuanjun.mybatis.configuration.DataSourceNames;
import com.yuanjun.mybatis.entity.Tag;
import com.yuanjun.mybatis.repository.TagRepository;
import com.yuanjun.mybatis.service.TagService;
import com.yuanjun.mybatis.vo.TagVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * @author shimh
 * <p>
 * 2018年1月25日
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;


    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public Tag getTagById(Integer id) {
        return tagRepository.getOne(id);
    }
	@Override
	public Tag getTagByFirstId(Integer id) {
		return tagRepository.getOne(id);
	}
	@CurDataSource(name= DataSourceNames.SECOND)
	@Override
	public Tag getTagBySecondId(Integer id) {
		return tagRepository.getOne(id);
	}

	@Override
    @Transactional
    public Integer saveTag(Tag tag) {

        return tagRepository.save(tag).getId();
    }

    @Override
    @Transactional
    public Integer updateTag(Tag tag) {
        Tag oldTag = tagRepository.getOne(tag.getId());

        oldTag.setTagname(tag.getTagname());
        oldTag.setAvatar(tag.getAvatar());

        return oldTag.getId();
    }

    @Override
    @Transactional
    public void deleteTagById(Integer id) {
        tagRepository.delete(id);
    }

    @Override
    public List<Tag> listHotTags(int limit) {

        return tagRepository.listHotTagsByArticleUse(limit);
    }

    @Override
    public List<TagVO> findAllDetail() {
        return tagRepository.findAllDetail();
    }

    @Override
    public TagVO getTagDetail(Integer tagId) {
        return tagRepository.getTagDetail(tagId);
    }
}
