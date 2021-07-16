package com.px.model;

public class PermissionModel {
    private int id;
    private String permissionCode;
    private String permissionName;

    public void setId(int id) {
        this.id = id;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public int getId() {
        return id;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public String getPermissionName() {
        return permissionName;
    }
}
