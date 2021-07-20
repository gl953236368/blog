package com.px.service.impl;

import com.px.mapper.ArticleMapper;
import com.px.mapper.TagMapper;
import com.px.model.ArticleModel;
import com.px.model.TagModel;
import com.px.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    TagMapper tagMapper;

    @Override
    public List<ArticleModel> getAllArticleDetail() {
        List<ArticleModel> articleModelList = articleMapper.getAllArticle();
        for(ArticleModel articleModel:articleModelList){
            List<TagModel> tagModels = tagMapper.findTagByArticleId(articleModel.getId());
            articleModel.setTagModels(tagModels);
        }
        return articleModelList;
    }
}
