package com.px.service.impl;

import com.px.mapper.PermissionMapper;
import com.px.model.PermissionModel;
import com.px.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public List<PermissionModel> findPermissionsByUser(int id) {
        return permissionMapper.findPermissionsByUser(id);
    }

    @Override
    public List<PermissionModel> findPermissionsByPath(String reqUrl) {
        return permissionMapper.findPermissionsByPath(reqUrl);
    }
}
