package com.px.model;

import java.util.List;

/**
 *  用户唯一
 */

public class UserModel {
    private int id;
    private String username;
    private String password;
    private String token;
    RoleModel roleModel;

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setRoleModel(RoleModel roleModel) {
        this.roleModel = roleModel;
    }

    public RoleModel getRoleModel() {
        return roleModel;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
