package com.px.mapper;

import com.px.model.TagModel;

import java.util.List;

public interface TagMapper {

    List<TagModel> findTagByArticleId(int id);
}
