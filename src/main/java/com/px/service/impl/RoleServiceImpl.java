package com.px.service.impl;

import com.px.mapper.PermissionMapper;
import com.px.mapper.RoleMapper;
import com.px.model.PermissionModel;
import com.px.model.RoleModel;
import com.px.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public RoleModel findPermissionByRole(String roleName) {
        RoleModel roleModel = roleMapper.findRoleByName(roleName);
        roleModel.setPermissionModelList(permissionMapper.findPermissionsByRole(roleName));
        return roleModel;
    }
}
