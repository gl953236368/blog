package com.px.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.px.model.ArticleModel;
import com.px.model.UserModel;
import com.px.service.ArticleService;
import com.px.service.UserService;
import com.px.utils.ResultCode;
import com.px.utils.ResultTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/admin")
@RestController
public class AdminController {

    @Autowired
    UserService userService;
    @Autowired
    ArticleService articleService;

    @RequestMapping("/init")
    public String initView(){
        /**
         * 初始化
         */
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        JSONObject jsonObject = new JSONObject();
        // 用户信息
        List<UserModel> userModels = userService.getUserList();
        // 文章信息
        List<ArticleModel> articleModels = articleService.getAllArticleDetail();
        jsonObject.put("userdetails", userModels);
        jsonObject.put("articledetails", articleModels);
        jsonObject.put("user", auth.getPrincipal());

        String userModelsJson = JSON.toJSONString(jsonObject);
        return userModelsJson;
    }

    @RequestMapping("/edit/role")
    public String editRolePermission(int userId, int roleId){
        userService.toEditUserRole(userId, roleId);
        return JSON.toJSONString(ResultTool.success());
    }

}
