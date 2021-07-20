package com.px.controller;

import com.alibaba.fastjson.JSON;
import com.px.model.UserModel;
import com.px.service.UserService;
import com.px.utils.JsonResult;
import com.px.utils.ResultCode;
import com.px.utils.ResultTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import static com.px.utils.ResultCode.USER_ACCOUNT_ALREADY_EXIST;

@RequestMapping("/auth")
@RestController
public class LoginController {
    /**
     * 注册用户 验证
     */

    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String getLogin(@RequestBody UserModel userModel){
        if(isExistence(userModel.getUsername())){
            return JSON.toJSONString(ResultTool.fail(USER_ACCOUNT_ALREADY_EXIST));
        }
        // 加密密码 入库
        String password = userModel.getPassword();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        userModel.setPassword(bCryptPasswordEncoder.encode(password));

        userService.toSaveUser(userModel);
        JsonResult result = ResultTool.success();
        return JSON.toJSONString(result);
    }

    // 确保username是唯一的
    public Boolean isExistence(String username){
        UserModel user = userService.findUserByName(username);
        return user != null;
    }
}
