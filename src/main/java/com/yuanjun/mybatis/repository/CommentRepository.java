package com.yuanjun.mybatis.repository;

import com.yuanjun.mybatis.entity.Article;
import com.yuanjun.mybatis.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * @author shimh
 * <p>
 * 2018年1月25日
 */
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findByArticleAndLevelOrderByCreateDateDesc(Article a, String level);


}
