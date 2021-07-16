package com.px.service;

import com.px.model.PermissionModel;

import java.util.List;

public interface PermissionService {
    List<PermissionModel> findPermissionsByUser(int id);

    List<PermissionModel> findPermissionsByPath(String reqUrl);
}
