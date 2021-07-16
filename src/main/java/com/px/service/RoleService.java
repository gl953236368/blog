package com.px.service;

import com.px.model.RoleModel;

import java.util.List;

public interface RoleService {

    RoleModel findPermissionByRole(String roleName);
}
