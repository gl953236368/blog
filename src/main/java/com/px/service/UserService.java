package com.px.service;

import com.px.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel findUserByName(String username);

    // 获得所有对象 以及权限信息
    List<UserModel> getUserList();

    // 保存对象 以及默认用户
    void toSaveUser(UserModel userModel);

    // 修改当前用户 的角色
    void toEditUserRole(int userId, int roleId);
}
