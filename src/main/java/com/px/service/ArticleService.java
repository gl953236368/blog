package com.px.service;

import com.px.model.ArticleModel;

import java.util.List;

public interface ArticleService {

    // 获得所有的文章信息
    List<ArticleModel> getAllArticleDetail();
}
