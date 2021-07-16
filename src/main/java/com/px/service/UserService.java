package com.px.service;

import com.px.model.UserModel;

public interface UserService {
    UserModel findUserByName(String username);
}
