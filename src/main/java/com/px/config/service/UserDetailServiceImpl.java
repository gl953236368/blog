package com.px.config.service;


import com.alibaba.fastjson.JSON;
import com.px.model.PermissionModel;
import com.px.model.UserModel;
import com.px.service.PermissionService;
import com.px.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    private Logger logger = Logger.getLogger(UserDetailServiceImpl.class.getName());


    // 登陆验证时，通过username获取用户的所有权限信息； 正式环境中就是查询用户数据授权
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(String.format("==========用户{%s}身份认证==========",username));
//        UserModel userModel = new UserModel();
//        userModel.setUsername(username);
//        userModel.setPassword(passwordEncoder.encode("123456"));
//        List listList = new ArrayList();
        if (username == null || "".equals(username)) {
            throw new RuntimeException("用户不能为空");
        }
        UserModel userModel = userService.findUserByName(username);
        System.out.println(String.format("用户：%s", JSON.toJSON(userModel).toString()));
        if(userModel == null){
            throw new RuntimeException("用户不存在");
        }
        List<GrantedAuthority> list = new ArrayList<>();
        if(userModel.getRoleModel() != null){
            List<PermissionModel> permissionModels = permissionService.findPermissionsByUser(userModel.getId());
            permissionModels.forEach(permissionModel ->{
                System.out.println("扫库对应用户的 权限："+permissionModel.getPermissionCode());
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permissionModel.getPermissionCode());
                list.add(grantedAuthority);
            });
        }

        return new User(userModel.getUsername(), userModel.getPassword(), true, true, true,true, list);
    }
}
