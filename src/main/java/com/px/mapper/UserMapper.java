package com.px.mapper;

import com.px.model.UserModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    UserModel findUserByName(String username);

    List<UserModel> getUserList();

    void toSaveUser(@Param("userModel") UserModel userModel);

    void toSaveUserAndRole(String username);

    void toEditUserRole(int userId, int roleId);
}
