package com.px.service.impl;

import com.px.mapper.UserMapper;
import com.px.model.UserModel;
import com.px.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserModel findUserByName(String username) {
        return userMapper.findUserByName(username);
    }

    @Override
    public List<UserModel> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public void toSaveUser(UserModel userModel) {
        userMapper.toSaveUser(userModel);
        userMapper.toSaveUserAndRole(userModel.getUsername());
    }

    @Override
    public void toEditUserRole(int userId, int roleId) {
        userMapper.toEditUserRole(userId, roleId);
    }
}
