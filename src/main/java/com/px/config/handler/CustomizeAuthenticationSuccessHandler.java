package com.px.config.handler;

import com.alibaba.fastjson.JSON;
import com.px.model.PermissionModel;
import com.px.model.RoleModel;
import com.px.model.UserModel;
import com.px.service.RoleService;
import com.px.service.UserService;
import com.px.utils.JsonResult;
import com.px.utils.JwtTokenUtils;
import com.px.utils.ResultTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//添加JWT,将t权限信息保存到token中,待会验证时再取出权限进行鉴权
@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // 包括权限
        UserModel userModel = userService.findUserByName(user.getUsername());
        String roleName = userModel.getRoleModel().getName();
        RoleModel roleModel = roleService.findPermissionByRole(roleName);
        String permission = "";
        // 可更新用户的状态 TODO
        // 便利出来角色的拥有的权限
        for(PermissionModel permissionModel: roleModel.getPermissionModelList()){
            permission += permissionModel.getPermissionCode() + ",";
        }
        System.out.println("jwt生成的权限："+ permission);
        permission = permission.substring(0, permission.length() - 1);

        String token = JwtTokenUtils.createToken(user.getUsername(), permission);
        userModel.setToken(token);
        // 返回json数据
        JsonResult result = ResultTool.success();
        result.setData(JSON.toJSONString(userModel).toString());

        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }
}