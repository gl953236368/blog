package com.px.mapper;

import com.px.model.UserModel;

public interface UserMapper {

    UserModel findUserByName(String username);
}
