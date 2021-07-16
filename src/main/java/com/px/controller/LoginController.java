package com.px.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth1")
@RestController
public class LoginController {

    @RequestMapping("/login1")
    public String getLogin(){
        return "xxx";
    }

}
