package com.px.mapper;

import com.px.model.PermissionModel;
import com.px.model.RoleModel;

import java.util.List;

public interface RoleMapper {
    RoleModel findRoleByName(String roleName);
}
