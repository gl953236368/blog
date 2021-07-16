package com.px.model;

import java.util.List;

/**
 * 角色拥有多种权限
 */
public class RoleModel {
    private int id;
    private String name;
    private String description;
    List<PermissionModel> permissionModelList;

    public void setPermissionModelList(List<PermissionModel> permissionModelList) {
        this.permissionModelList = permissionModelList;
    }

    public List<PermissionModel> getPermissionModelList() {
        return permissionModelList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
