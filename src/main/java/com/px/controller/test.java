package com.px.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class test {

    @RequestMapping("/ttt")
    public String getSign(){
        return "2222";
    }

    @RequestMapping("/getUser")
    public String getUser(){
        return "user";
    }
}
