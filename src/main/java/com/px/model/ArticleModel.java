package com.px.model;


import java.util.Date;
import java.util.List;

public class ArticleModel {
    private int id;
    private String username; // 用户username
    private String nickname;
    private String title;
    private String intro;
    private String content;
    private Date createDate;
    private Date updateDate;
    private int status; // 文章状态
    List<TagModel> tagModels; // 文章标签
//    ArticleStaticModel articleStaticModel;  // 文章

    public void setId(int id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTagModels(List<TagModel> tagModels) {
        this.tagModels = tagModels;
    }

    public int getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTitle() {
        return title;
    }

    public String getIntro() {
        return intro;
    }

    public String getContent() {
        return content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public int getStatus() {
        return status;
    }

    public List<TagModel> getTagModels() {
        return tagModels;
    }
}
