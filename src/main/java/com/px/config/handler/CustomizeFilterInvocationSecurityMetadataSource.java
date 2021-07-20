package com.px.config.handler;

import com.px.model.PermissionModel;
import com.px.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

@Component
public class CustomizeFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Autowired
    PermissionService permissionService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        // 获取请求地址
        String reqUrl = ((FilterInvocation) o).getRequestUrl();
        String pathUrl = reqUrl.split("\\?")[0];
        System.out.println("请求路径:"+pathUrl);
        List<PermissionModel> permissions = permissionService.findPermissionsByPath(pathUrl);
        if (permissions == null || permissions.size() == 0) {
            //无配置 无权限 任何都可访问
            return null;
        }
        String[] attr = new String[permissions.size()];
        for (int i = 0; i < permissions.size(); i++) {
            attr[i] = permissions.get(i).getPermissionCode();
        }

        return SecurityConfig.createList(attr);
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
