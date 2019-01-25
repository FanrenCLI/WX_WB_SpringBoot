package com.fanren.wx.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: FanrenCLI
 * @Date: 2019/1/24 14:59
 * @Description: Class
 * @version:
 */

@RestController
public class login {

    @RequestMapping("/login")
    public String getuserInfo(@RequestParam(value="id") String id,@RequestParam(value = "pwd") String pwd){

        return null;
    }
}
