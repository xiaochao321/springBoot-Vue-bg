package com.yuanjun.mybatis.repository.wrapper;



import com.yuanjun.mybatis.entity.Article;
import com.yuanjun.mybatis.vo.ArticleVo;
import com.yuanjun.mybatis.vo.PageVo;

import java.util.List;

public interface ArticleWrapper {
    List<Article> listArticles(PageVo page);

    List<Article> listArticles(ArticleVo article, PageVo page);

    List<ArticleVo> listArchives();

}
