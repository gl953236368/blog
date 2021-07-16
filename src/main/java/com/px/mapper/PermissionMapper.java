package com.px.mapper;

import com.px.model.PermissionModel;

import java.util.List;

public interface PermissionMapper {
    List<PermissionModel> findPermissionsByUser(int id);

    List<PermissionModel> findPermissionsByPath(String reqUrl);

    List<PermissionModel> findPermissionsByRole(String roleName);
}
