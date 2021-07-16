package com.px.service.impl;

import com.px.mapper.UserMapper;
import com.px.model.UserModel;
import com.px.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserModel findUserByName(String username) {
        return userMapper.findUserByName(username);
    }
}
