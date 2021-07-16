package com.px.config.handler;


import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

// 访问决策管理器
@Component
public class CustomizeAccessDecisionManager implements AccessDecisionManager {

    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {

        Iterator<ConfigAttribute> iterator = collection.iterator();
        //当前用户所具有的权限
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        //当前请求需要的权限
        while (iterator.hasNext()) {
            ConfigAttribute ca = iterator.next();
            //当前请求需要的权限
            String needRole = ca.getAttribute();
            for (GrantedAuthority authority : authorities) {
                System.out.println(authority.getAuthority());
                if (authority.getAuthority().equals(needRole)) {
                    return;
                }
            }
        }
        //抛出AccessDeniedException异常,下面会新建个方法去捕获异常
        throw new AccessDeniedException("没有权限!");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
